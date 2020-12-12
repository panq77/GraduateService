package pq.empm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pq.empm.model.User;
import pq.empm.service.UserService;
import pq.empm.util.JsonResult;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("users")
public class UserController extends BaseController{
    private UserService userService;
    @Autowired
    public void UserService(UserService userService){
        this.userService=userService;
    }
    @RequestMapping("reg")
    public JsonResult<Void> regist(String uname,String pwd){
               userService.regist(uname,pwd);
           return  new JsonResult<Void>();

    }
    @RequestMapping("login")
    public JsonResult<User> login(HttpSession session,String uname, String pwd){
         User u=userService.login(uname,pwd);
         session.setAttribute(u.getUname(),u);
         return new JsonResult<User>(u);
    }

    @RequestMapping("updateUserInfo")
    public JsonResult<Void> updateInfo(HttpSession session,User u){
        userService.updateUserInfo(u);
        u.setPwd(null);
        session.setAttribute(u.getUname(),u);
        return new JsonResult<Void>();
    }

}
