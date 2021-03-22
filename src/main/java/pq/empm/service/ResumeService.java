package pq.empm.service;

import org.springframework.web.multipart.MultipartFile;
import pq.empm.model.Resume;
import pq.empm.vo.NotifyItem;
import pq.empm.vo.ReceiveItem;

import java.util.List;

public interface ResumeService {
    void uploadResume(Resume resume,MultipartFile file);

    Resume download(int rid);

    void backResume(int rid);

    void success(int rid);

    List<ReceiveItem> getBox(String jid,Integer pid);

    void checked(Integer uid, String jid);

    void delResumeBox( String jid);

    List<NotifyItem> queryResumeByUid(Integer uid);

    void delResume(Integer rid);
}
