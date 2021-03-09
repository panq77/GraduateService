package pq.empm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.data.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pq.empm.model.Publisher;
import pq.empm.model.User;
import pq.empm.service.PublisherService;
import pq.empm.util.MapperUtil;
import pq.empm.vo.JsonResult;
import pq.empm.vo.LogData;
import pq.empm.vo.ReceiveItem;

import javax.servlet.http.HttpSession;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/publisher")
public class PublisherController extends  BaseController{
    @Autowired
    private PublisherService publisherService;
    @RequestMapping("/reg")
    public JsonResult<Void> reg(Publisher publisher){
        publisherService.regist(publisher);
        return new JsonResult<>();
    }
    @RequestMapping("/login")
    public JsonResult<Publisher> login(HttpSession session,String name,String pwd) throws JsonProcessingException {
           Publisher publisher= publisherService.login(name,pwd);
           session.setAttribute("p_username",publisher);
           /**
            * 日活
            * */
           log.info(MapperUtil.MP.writeValueAsString(new LogData(publisher.getPid(),"p_login")));
           return new JsonResult<>(publisher);
    }
    @RequestMapping("/update")
    public JsonResult<Publisher> updateInfo(HttpSession session,Publisher publisher){
        Publisher p = (Publisher) session.getAttribute("p_username");
        publisher.setName(p.getName());
        Publisher pub=publisherService.updateInfo(publisher);
        session.setAttribute("p_username",pub);
        return new JsonResult<>(pub);
    }
    @RequestMapping("check_login")
    public JsonResult<Publisher> checkLogin(HttpSession session){
        Publisher username = (Publisher) session.getAttribute("p_username");
        if (username!=null){
            return new JsonResult<>(username);
        }else {
            JsonResult<Publisher> jr = new JsonResult<>();
            jr.setCode(203);
            return  jr;
        }
    }
    @RequestMapping("query_info")
    public JsonResult<Publisher> getUserInfo(String name){
        Publisher p=publisherService.queryInfo(name);

        return new JsonResult<>(p);
    }
}
