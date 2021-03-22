package pq.empm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.data.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pq.empm.ex.NoVisit;
import pq.empm.model.Job;
import pq.empm.model.Publisher;
import pq.empm.model.User;
import pq.empm.service.JobService;
import pq.empm.util.CheckNull;
import pq.empm.util.CookieUtils;
import pq.empm.util.MapperUtil;
import pq.empm.vo.JsonResult;
import pq.empm.vo.LogData;
import pq.empm.vo.PublisherJob;
import pq.empm.vo.VisitJob;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/job")
public class JobController extends BaseController {

    @Autowired
    private JobService jobService;

    //根据id查询job信息
    @RequestMapping("/queryDetail")
    public JsonResult<Job> queryDetailById(HttpServletRequest request, HttpServletResponse response,
                                           HttpSession session, String jid) throws JsonProcessingException, UnsupportedEncodingException {
        Job job = jobService.queryDetailById(jid);

        /**
         * 记录日志系统
         * */
        User u = (User) session.getAttribute("username");
        String visitListJson = CookieUtils.getCookieValue(request,"visit");

        LinkedList<VisitJob> visitList;
        VisitJob visitJob = new VisitJob(job.getJid(), job.getName(), job.getJcommpanyName());
        if (visitListJson != null) {
            String visitListJsonDecode = URLDecoder.decode(visitListJson, "utf-8");
            visitList =  MapperUtil.MP.readValue(visitListJsonDecode, LinkedList.class);


            if (visitList.size()==6) {
                    visitList.pop();

            }
        } else {
            visitList = new LinkedList<>();
        }
        visitList.offerFirst(visitJob);

        String back = MapperUtil.MP.writeValueAsString(visitList);
        CookieUtils.setCookie(request, response,"visit",  URLEncoder.encode(back, "utf-8"));


        log.info(MapperUtil.MP.writeValueAsString(new LogData(
                u.getUid(), u.getUname(), (Integer) CheckNull.check(u.getAge()), (Integer) CheckNull.check(u.getGender()), CheckNull.check(u.getExpectedJob()).toString(),
                CheckNull.check(u.getExpectedEara()).toString(),CheckNull.check(u.getEducation()).toString(),
                ((Integer)CheckNull.check(u.getHasExperience())).toString(), "click_job",
                job.getJid(), job.getName(), job.getTypeC(), job.getSalary(), job.getJcommpanyName(),
                job.getJcommpanyType(), job.getJcommpanyScale(), job.getJarea(), job.getPid()
        )));

        return new JsonResult<>(job);
    }



    //publisher查看自己发布的岗位
    @RequestMapping("/queryList")
    public JsonResult<List<Job>> queryList(HttpSession session) {
        Publisher publisher = (Publisher) session.getAttribute("p_username");
        List<Job> joblist = jobService.queryById(publisher.getPid());
        return new JsonResult<>(joblist);
    }

    //publisher查看自己发布的岗位的所有信息
    @RequestMapping("/queryAll")
    public JsonResult<Job> queryAll(String jid) {

        Job job = jobService.queryAllById(jid);
        return new JsonResult<>(job);
    }

    //publisher发布岗位信息
    @RequestMapping("/add")
    public JsonResult<Void> addJob(HttpSession session, Job job) throws JsonProcessingException {
        System.out.println(job);
        Publisher publisher = (Publisher) session.getAttribute("p_username");
        job.setPid(publisher.getPid());
        jobService.addJob(job);
        return new JsonResult<>();
    }

    @RequestMapping("delete")
    public JsonResult<Void> removeJob(HttpSession session,String jid) {
        Publisher publisher = (Publisher) session.getAttribute("p_username");

        jobService.removeJob(publisher.getPid(),jid);
        return new JsonResult<>();
    }

    @RequestMapping("hot_job_list")
    public JsonResult<List<Job>> getHotList() {
        List<Job> jobs = jobService.queryHotList();
        return new JsonResult<>(jobs);
    }

    @RequestMapping("type")
    public JsonResult<List<Map>> queryType(String type) {
        List<Map> maps = jobService.queryType(type);

        return new JsonResult<>(maps);
    }

    @RequestMapping("commpany_type")
    public JsonResult<List<Map>> queryCommpanyType() {
        List<Map> maps = jobService.queryCommpanyType();

        return new JsonResult<>(maps);
    }

    @RequestMapping("visited_job")
    public JsonResult<List<VisitJob>> getVisited(HttpServletRequest request, HttpSession session) throws JsonProcessingException, UnsupportedEncodingException {
        User u = (User) session.getAttribute("username");
        String visitListJson = CookieUtils.getCookieValue(request, "visit");
        if (visitListJson == null) {
            throw new NoVisit("没有访问记录");
        }
        String visitListJsonDecode = URLDecoder.decode(visitListJson, "utf-8");
        LinkedList<VisitJob> visitList = MapperUtil.MP.readValue(visitListJsonDecode, LinkedList.class);
       return  new JsonResult<>(visitList);
    }
    @RequestMapping("publisher_job_list")
    public JsonResult<List<PublisherJob>> getPublisherJobsById(HttpSession session){

        Publisher publisher = (Publisher) session.getAttribute("p_username");
        List<PublisherJob> jobs=jobService.queryPublisherJobsById(publisher.getPid());
        return new JsonResult<>(jobs);
    }
    @RequestMapping("recommend")
    public JsonResult<List<Map>> RecommendJob(HttpSession session){
        User u = (User) session.getAttribute("username");
        List<Map> maps=jobService.recommendJob(u);
        System.out.println("recommend"+maps);
        return  new JsonResult<>(maps);
    }

    @RequestMapping("type_c")
    public JsonResult<List<Map>> queryAllTypeC(){
        List<Map> maps = jobService.queryTypeC();
        return new JsonResult<>(maps);
    }
}
