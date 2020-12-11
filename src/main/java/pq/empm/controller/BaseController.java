package pq.empm.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import pq.empm.ex.*;
import pq.empm.util.JsonResult;

public abstract class BaseController {
    @ExceptionHandler(BaseEx.class)
    @ResponseBody
    public JsonResult<Void> handlerException(Throwable e) {
        JsonResult<Void> jr = new JsonResult<>();
        if(e instanceof UserExist){
            jr.setCode(20);
            jr.setMessage(e.getMessage());
        }else if (e instanceof Inserterror){
            jr.setMessage(e.getMessage());
            jr.setCode(21);
        }else if(e instanceof UserNoFound){
            jr.setCode(22);
            jr.setMessage(e.getMessage());
        }else if( e instanceof PwdNotMatch){
            jr.setMessage(e.getMessage());
            jr.setCode(23);
        }
        return jr;
    }
}
