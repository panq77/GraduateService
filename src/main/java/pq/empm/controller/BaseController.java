package pq.empm.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import pq.empm.ex.*;
import pq.empm.vo.JsonResult;

public abstract class BaseController {
    @ExceptionHandler(BaseEx.class)
    @ResponseBody
    public JsonResult<Void> handlerException(Throwable e) {
        JsonResult<Void> jr = new JsonResult<>();
        if(e instanceof UserExist){
           setError(jr,e);
        }else if (e instanceof Inserterror){
            setError(jr,e);
        }else if(e instanceof UserNoFound){
            setError(jr,e);
        }else if( e instanceof PwdNotMatch){
            setError(jr,e);
        }else if(e instanceof updateError){
            setError(jr,e);
        }else if(e instanceof JobNotExist){
            setError(jr,e);
        }else if(e instanceof FileSuffixNotMatch){
            setError(jr,e);
        }
        else if(e instanceof FileUploadError){
            setError(jr,e);
        }
        else if(e instanceof ResumeHasDel){
            setError(jr,e);
        }
        else if(e instanceof NoVisit){
            setError(jr,e);
        }
        else if(e instanceof ResumeHasExist){
            setError(jr,e);
        }
        else if(e instanceof ResumeNotHandle){
            setError(jr,e);
        }
        else if(e instanceof NoMailForType){
            setError(jr,e);
        }
        return jr;
    }
    private void setError(JsonResult<Void> jr,Throwable e){
        jr.setMessage(e.getMessage());
        jr.setCode(123);
    }
}
