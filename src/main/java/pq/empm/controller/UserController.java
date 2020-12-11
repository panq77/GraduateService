package pq.empm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pq.empm.model.User;
import pq.empm.service.UserService;
import pq.empm.util.JsonResult;

@RestController
@RequestMapping("users")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;
    @RequestMapping("reg")
    public JsonResult<Void> regist(String uname,String pwd){
               userService.regist(uname,pwd);
           return  new JsonResult<Void>();

    }
    @RequestMapping("login")
    public JsonResult<User> login(String uname, String pwd){
         User u=userService.login(uname,pwd);
         return new JsonResult<User>(u);
    }



}
