package pq.empm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pq.empm.model.Publisher;
import pq.empm.service.PublisherService;
import pq.empm.vo.JsonResult;
import pq.empm.vo.ReceiveItem;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    public JsonResult<Publisher> login(HttpSession session,String name,String pwd){
           Publisher publisher= publisherService.login(name,pwd);
           session.setAttribute("p_username",publisher);
           return new JsonResult<>(publisher);
    }
    @RequestMapping("/update")
    public JsonResult<Publisher> updateInfo(HttpSession session,Publisher publisher){
        Publisher p = (Publisher) session.getAttribute("p_username");
        publisher.setPid(p.getPid());
        Publisher pub=publisherService.updateInfo(publisher);
        session.setAttribute("p_username",pub);
        return new JsonResult<>(pub);
    }


}
