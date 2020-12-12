package pq.empm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pq.empm.dao.UserMapper;
import pq.empm.ex.*;
import pq.empm.model.User;
import pq.empm.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Autowired(required = false)
     void UserMapper(UserMapper userMapper){
        this.userMapper=userMapper;
    }
    @Override
    public void regist(String uname,String pwd) {
        User u=userMapper.queryByName(uname);
        if(u==null){
            User user=new User();
            user.setUname(uname);
            user.setPwd(pwd);
            int count=userMapper.insertSelective(user);
            if(count==0){
                throw new Inserterror("注册失败，请重试");
            }
        }else{
            throw new UserExist("用户名已存在");
        }
    }

    @Override
    public User login(String uname,String pwd) {
        User user = userMapper.queryByName(uname);
        System.out.println(user);
        if(user==null){
            throw new UserNoFound("用户不存在或密码不正确");
        }else{
            if(user.getPwd().equals(pwd)){
               user.setPwd(null);
            }else{
                throw new PwdNotMatch("用户名不存在或密码不正确");
            }
        }
        return user;
    }

    @Override
    public void updateUserInfo(User u) {
         int count=userMapper.update(u);
         if(count==0){
             throw new updateError("操作失败，请重试");
         }
    }
}
