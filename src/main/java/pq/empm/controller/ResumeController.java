package pq.empm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pq.empm.model.Publisher;
import pq.empm.model.Resume;
import pq.empm.model.User;
import pq.empm.service.JobService;
import pq.empm.service.ResumeService;
import pq.empm.util.CheckNull;
import pq.empm.util.MapperUtil;
import pq.empm.vo.JsonResult;
import pq.empm.vo.LogData;
import pq.empm.vo.ReceiveItem;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/resume")
public class ResumeController extends BaseController {
    @Autowired
    private ResumeService resumeService;

    @Autowired
    private JobService jobService;
    //resume : jid jname pid
    @RequestMapping("/mailing")
    public JsonResult<Void> mailResume(HttpSession session, Resume resume, MultipartFile file) throws JsonProcessingException {

        User user = (User) session.getAttribute("username");
        resume.setUid(user.getUid());
        resumeService.uploadResume(resume, file);
        /**
         * 记入日志系统
         * */
        String typeC=jobService.queryJobType(resume.getJid());

        log.info(MapperUtil.MP.writeValueAsString(new LogData(  user.getUid(),user.getUname(),(Integer) CheckNull.check(user.getAge()),
                (Integer) CheckNull.check(user.getGender()),  CheckNull.check(user.getExpectedJob()).toString(),CheckNull.check(user.getExpectedEara()).toString(),
                CheckNull.check(user.getEducation()).toString(),((Integer)CheckNull.check(user.getHasExperience())).toString(),"mailing_job", resume.getJid(),resume.getJname(),typeC,resume.getPid())));

        return new JsonResult<>();
    }

    @RequestMapping("/download")
    public String downLoad(HttpServletResponse response, int rid) throws IOException {
        Resume resume = resumeService.download(rid);
        String downloadFilePath = resume.getUrl();//被下载的文件在服务器中的路径,
        String fileName = resume.getNewname();//被下载文件的名称
        File file = new File(downloadFilePath);
        if (file.exists()) {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setContentType("application/octet-stream");
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream outputStream = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    outputStream.write(buffer, 0, i);
                    i = bis.read(buffer);
                }

                return "下载成功";
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "下载失败";
    }

    @RequestMapping("back")
    public JsonResult<Void> backResume(int rid) {
        resumeService.backResume(rid);
        return new JsonResult<>();
    }
    @RequestMapping("success")
    public JsonResult<Void> success(int rid){
        resumeService.success(rid);
        return  new JsonResult<>();
    }

    @RequestMapping("checked")
     public JsonResult<Void> checkedMail(HttpSession session,String jid){
        User u = (User) session.getAttribute("username");
        resumeService.checked(u.getUid(),jid);
        return new JsonResult<>();
    }
    @RequestMapping("resume_list")
    public  JsonResult<List<ReceiveItem>> getResumeList(HttpSession session,String jid) throws JsonProcessingException {
        Publisher p = (Publisher) session.getAttribute("p_username");
        List<ReceiveItem> box = resumeService.getBox(jid, p.getPid());
        log.info(MapperUtil.MP.writeValueAsString(new LogData(p.getPid(),"p_handle_resume",jid)));
        return new JsonResult<>(box);
    }
}
