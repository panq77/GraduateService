package pq.empm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import pq.empm.dao.ResumeMapper;
import pq.empm.ex.FileSuffixNotMatch;
import pq.empm.ex.ResumeHasDel;
import pq.empm.model.Resume;
import pq.empm.service.ResumeService;
import pq.empm.util.UploadUtil;
import pq.empm.vo.ReceiveItem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ResumeServiceImpl implements ResumeService {
@Autowired
private ResumeMapper resumeMapper;
    @Override
    @Transactional
    public void uploadResume(Resume resume,MultipartFile file) {

        //拿到原名称 originalFileName
        String oName = file.getOriginalFilename();
        //获取后缀验证文件格式
        String extName=oName.substring(oName.lastIndexOf("."));
        //上传原名
        String fileName = oName.split("\\.")[0];

        //利用正则表达式 match
        String regex="\\.(doc|pdf|docx)$";
        boolean matches = extName.matches(regex);

        if(!matches){
            //文件名称后缀不合法 返回一个PicUploadResult
            throw new FileSuffixNotMatch("不能上传该格式文件"+extName);
        }

        String path= UploadUtil.getUploadPath(
                UUID.randomUUID().toString(),
                "/graduate")+"/";

        String newFileName=System.currentTimeMillis()+extName;

        File dir=new File("d:/resume"+path);
        if(!dir.exists()){
            //不存在,创建多级目录
            dir.mkdirs();
        }


        try {
            file.transferTo(new File(
                    "d:/resume"
                            +path+newFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //d:/file/graduate/d/7/5/c/b/9/3/b/1614076411475.docx
        String url="d:/resume"
                +path+newFileName;
        resume.setUrl(url);
        resume.setName(fileName);
        resume.setStat("0");
        resume.setNewname(newFileName);
        resumeMapper.insert(resume);
        return;
    }

    @Override
    public Resume download(int rid) {
        return resumeMapper.queryById(rid);
    }

    @Override
    public void backResume(int rid) {
        Resume resume = resumeMapper.queryById(rid);
        if(resume!=null){
            resumeMapper.deleteById(rid);
        }else{
            throw new ResumeHasDel("已删除");
        }

    }

    @Override
    public void success(int rid) {
        resumeMapper.updateStat(rid);
    }

    @Override
    public List<ReceiveItem> getBox(Integer pid) {
        List<Resume> resumes=resumeMapper.getListById(pid);
        List<ReceiveItem> box=new ArrayList<>();
        for (Resume resume: resumes){
            box.add(new ReceiveItem(resume.getRid(),resume.getJname(),resume.getName()));
        }
        return box;
    }
}
