package pq.empm.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pq.empm.model.User;

public interface UserMapper {
    //注册先查询账号是否存在 在插入数据库
    //登录先查询用户名是否存在 在校验密码
    int insert(User record);
    int insertSelective(User record);
    User queryByName(@Param("uname") String uname);
    //动态更新
    int update(User user);

}