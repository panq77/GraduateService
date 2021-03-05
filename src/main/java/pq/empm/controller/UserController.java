package pq.empm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pq.empm.model.User;
import pq.empm.service.UserService;
import pq.empm.util.MapperUtil;
import pq.empm.vo.JsonResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Slf4j
@RestController
@RequestMapping("users")
public class UserController extends BaseController{
    private UserService userService;
    @Autowired
    public void UserService(UserService userService){
        this.userService=userService;
    }
    @RequestMapping("reg")
    public JsonResult<Void> regist(String name,String pwd){
               userService.regist(name,pwd);
           return  new JsonResult<Void>();

    }
    @RequestMapping("login")
    public JsonResult<User> login(HttpSession session,String name, String pwd) throws JsonProcessingException {
         User u=userService.login(name,pwd);
         session.setAttribute("username",u);
         return new JsonResult<User>(u);
    }
    @RequestMapping("logout")
    public JsonResult<Void> logout( HttpServletRequest request){
        request.getSession().invalidate();
        return new JsonResult<Void>();
    }
    @RequestMapping("update_user_info")
    public JsonResult<Void> updateInfo(HttpSession session,User u){
        User user = (User) session.getAttribute("username");

        User user1 = userService.updateUserInfo(u);
        user1.setPwd(null);


        if (user!=null){
            session.setAttribute("username",user1);
        }
        return new JsonResult<Void>();
    }
    @RequestMapping("query_info")
    public JsonResult<User> getUserInfo(String uname){
        User u=userService.queryInfo(uname);

         return new JsonResult<>(u);
    }
    @RequestMapping("test")
    public JsonResult<Void> test(HttpSession session){
        User u = (User) session.getAttribute("username");

        return new JsonResult<>();
    }
    @RequestMapping("check_login")
    public JsonResult<User> checkLogin(HttpSession session){
        User username = (User) session.getAttribute("username");
        if (username!=null){
            return new JsonResult<>(username);
        }else {
            JsonResult<User> jr = new JsonResult<>();
            jr.setCode(203);
            return  jr;
        }
    }
}
