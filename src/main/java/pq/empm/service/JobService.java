package pq.empm.service;

import pq.empm.model.Job;

import java.util.List;
import java.util.Map;

public interface JobService {

    List<Job> queryById(Integer pid);

    Job queryDetailById(String jid);

    Job queryAllById(String jid);

    void addJob(Job job);

    String queryJobType(String jid);

    List<Job> queryHotList();

    List<Map> queryType(String typeB);

    List<Map> queryCommpanyType();
}
