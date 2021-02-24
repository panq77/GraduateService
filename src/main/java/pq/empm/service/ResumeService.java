package pq.empm.service;

import org.springframework.web.multipart.MultipartFile;
import pq.empm.model.Resume;
import pq.empm.vo.ReceiveItem;

import java.util.List;

public interface ResumeService {
    void uploadResume(Resume resume,MultipartFile file);

    Resume download(int rid);

    void backResume(int rid);

    void success(int rid);

    List<ReceiveItem> getBox(Integer pid);
}
