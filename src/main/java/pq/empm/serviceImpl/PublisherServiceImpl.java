package pq.empm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pq.empm.dao.PublisherMapper;
import pq.empm.ex.PwdNotMatch;
import pq.empm.ex.UserExist;
import pq.empm.ex.UserNoFound;
import pq.empm.ex.updateError;
import pq.empm.model.Publisher;
import pq.empm.model.User;
import pq.empm.service.PublisherService;
import pq.empm.util.MD5Util;

@Service
public class PublisherServiceImpl  implements PublisherService {
    @Autowired
    private PublisherMapper publisherMapper;

    @Override
    public void regist(Publisher publisher) {
        Publisher p = publisherMapper.queryByName(publisher.getName());
        if(p!=null){
            throw new UserExist("用户已存在");
        }
        publisher.setPwd(MD5Util.md5(publisher.getPwd()));
        publisherMapper.insert(publisher);
    }

    @Override
    public Publisher login(String name, String pwd) {
        Publisher publisher = publisherMapper.queryByName(name);
        if(publisher==null){
            throw new UserNoFound("用户不存在");
        }
        String mdPwd = MD5Util.md5(pwd);
        if(publisher.getPwd().equals(mdPwd)){
            publisher.setPwd(null);
        }else{
            throw new PwdNotMatch("密码不正确");
        }
        return publisher;
    }

    @Override
    public Publisher updateInfo(Publisher publisher) {
        Publisher p = publisherMapper.queryByName(publisher.getName());
        if (p != null) {
            if (!MD5Util.md5(publisher.getPwd()).equals(p.getPwd())){
                throw new PwdNotMatch("密码不正确");
            }
        }else {
            throw new UserNoFound("用户不存在");
        }
        publisher.setPwd(p.getPwd());
        int count = publisherMapper.update(publisher);
        if (count == 0) {
            throw new updateError("操作失败，请重试");
        }
        Publisher update = publisherMapper.queryByName(publisher.getName());
        return update;
    }

    @Override
    public Publisher queryInfo(String name) {
        Publisher publisher = publisherMapper.queryByName(name);
        return publisher;
    }
}
