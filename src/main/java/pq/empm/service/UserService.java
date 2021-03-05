package pq.empm.service;

import org.springframework.stereotype.Service;
import pq.empm.model.User;


public interface UserService {
    public void regist(String uname,String pwd);
    public User login(String uname,String pwd);
    public User updateUserInfo(User u);

    User queryInfo(String uname);
}
