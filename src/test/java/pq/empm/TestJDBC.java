package pq.empm;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pq.empm.dao.UserMapper;
import pq.empm.model.User;
import pq.empm.service.UserService;


@SpringBootTest
public class TestJDBC {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Test
    public void qname(){
        User pq = userService.login("ahh","123321");
        if(pq==null){
            System.out.println("不存在");
        } else{
            System.out.println(pq);
        }

    }
    @Test
    public void update(){
        User u=new User();
        u.setUid(2);
        u.setGender(1);
        u.setAge(21);
        userMapper.update(u);

    }
    @Test
    public void insertselect(){
        User u=new User();
        u.setUid(2);
        u.setAge(21);
        userMapper.insertSelective(u);

    }
}
