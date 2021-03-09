package pq.empm.dao;

import pq.empm.model.Job;
import pq.empm.vo.PublisherJob;

import java.util.List;
import java.util.Map;

public interface JobMapper {
    int insert(Job record);
    Job queryAllById(String jid);
    Job queryDetailById(String jid);
    List<Job> queryById(int pid);
    int queryCount();
    List<Job> queryAll();
    String queryJobType(String jid);

    List<Job> queryHotJob(List<String> jidList);

    List<Map> queryTypeCByTypeB(String typeB);

    List<Map> queryCommpanyType();

    List<PublisherJob> queryPublisherJobsById(Integer pid);

     List<Map> recommendJob(String type,String date);
    int queryMax();

    void deleteByJid(String jid);

    List<Map> searchKey(Integer uid);

    List<Map> recommendJob2Method(String exJob);

    List<Map> queryAllTypeC();
}