package pq.empm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pq.empm.model.Job;
import pq.empm.model.Publisher;
import pq.empm.service.JobService;
import pq.empm.vo.JsonResult;

import javax.servlet.http.HttpSession;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/job")
public class JobController extends BaseController{
    /**
     *      暂定
     * 1 增删查
     * 2 增加job 并添加到es中
     * 3 删除  并删除es中的数据
     * 4 查询
     *   （1）查询本行业热门岗位
     *   （2）查询相关岗位
     *   （3）es分页查询 条件查询
     * */
    @Autowired
    private JobService jobService;
    //根据id查询job信息
    @RequestMapping("/queryDetail")
    public JsonResult<Job> queryDetailById(String jid){
        Job job=jobService.queryDetailById(jid);
        log.info(job.toString());
        return new JsonResult<>(job);
    }
    //publisher查看自己发布的岗位
    @RequestMapping("/queryList")
    public JsonResult<List<Job>> queryList(HttpSession session){
        Publisher publisher = (Publisher) session.getAttribute("p_username");

        List<Job> joblist=jobService.queryById(publisher.getPid());
        return new JsonResult<>(joblist);
    }
    //publisher查看自己发布的岗位的所有信息
    @RequestMapping("/queryAll")
    public JsonResult<Job> queryAll(String jid){

        Job job=jobService.queryAllById(jid);
        return new JsonResult<>(job);
    }
    //publisher发布岗位信息
    @RequestMapping("/add")
    public JsonResult<Void> addJob(HttpSession session,Job job){
        Publisher publisher = (Publisher) session.getAttribute("p_username");
        job.setPid(publisher.getPid());
        jobService.addJob(job);
        return  new JsonResult<>();
    }
    @RequestMapping("delete")
    public JsonResult<Void> removeJob(){
        return new JsonResult<>();
    }

    //热门岗位



}
