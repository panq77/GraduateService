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
    public JsonResult<Void> regist(String uname,String pwd){
               userService.regist(uname,pwd);

           return  new JsonResult<Void>();

    }
    @RequestMapping("login")
    public JsonResult<User> login(HttpSession session,String uname, String pwd) throws JsonProcessingException {
         User u=userService.login(uname,pwd);
         session.setAttribute("username",u);
         log.info(MapperUtil.MP.writeValueAsString(u));
         return new JsonResult<User>(u);
    }
    @RequestMapping("logout")
    public JsonResult<Void> logout( HttpServletRequest request){
        request.getSession().invalidate();
        return new JsonResult<Void>();
    }
    @RequestMapping("updateUserInfo")
    public JsonResult<Void> updateInfo(HttpSession session,User u){
        User user = (User) session.getAttribute("username");
        u.setUid(user.getUid());
        userService.updateUserInfo(u);
        u.setPwd(null);
        session.setAttribute("username",u);
        return new JsonResult<Void>();
    }
//    @RequestMapping("test")
//    public JsonResult<Void> test(HttpSession session){
//        User u = (User) session.getAttribute("pq");
//        System.out.println(u);
//        return new JsonResult<>();
//    }
}
