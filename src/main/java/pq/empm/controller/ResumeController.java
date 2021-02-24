package pq.empm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pq.empm.model.Publisher;
import pq.empm.model.Resume;
import pq.empm.model.User;
import pq.empm.service.ResumeService;
import pq.empm.vo.JsonResult;
import pq.empm.vo.ReceiveItem;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/resume")
public class ResumeController extends BaseController {
    @Autowired
    private ResumeService resumeService;

    @RequestMapping("/mailing")
    public JsonResult<Void> mailResume(HttpSession session, Resume resume, MultipartFile file) {

        User user = (User) session.getAttribute("username");
        resume.setUid(user.getUid());
        resumeService.uploadResume(resume, file);
        return new JsonResult<>();
    }

    @RequestMapping("/download")
    public String downLoad(HttpServletResponse response, int rid) throws IOException {
        Resume resume = resumeService.download(rid);
        String downloadFilePath = resume.getUrl();//被下载的文件在服务器中的路径,
        String fileName = resume.getNewname();//被下载文件的名称

        File file = new File(downloadFilePath);
        if (file.exists()) {

            response.setContentType("application/octet-stream");

            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
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
    @RequestMapping("/receive")
    public JsonResult<List<ReceiveItem>> getReceiveBox(HttpSession session){
        Publisher publisher = (Publisher) session.getAttribute("p_username");
        List<ReceiveItem> box = resumeService.getBox(publisher.getPid());
        return  new JsonResult<>(box);
    }
}
