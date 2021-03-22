package pq.empm.dao;

import pq.empm.model.Resume;
import pq.empm.vo.NotifyItem;

import java.util.List;

public interface ResumeMapper {


    int insert(Resume record);


    Resume queryById(int rid);

    int deleteById(int rid);

    int updateStat(int rid,String stat);

    List<Resume> getListById(Integer pid);

    Resume checkedByJidAndUid(String jid, Integer uid);

    List<Resume> queryResumeByPidAndJid(Integer pid, String jid);

    int updateStatByJid(String jid,String stat);

    List<NotifyItem> queryNotify(Integer uid);
}