package pq.empm.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import pq.empm.model.Job;
import pq.empm.model.User;
import pq.empm.vo.PublisherJob;

import java.util.List;
import java.util.Map;

public interface JobService {

    List<Job> queryById(Integer pid);

    Job queryDetailById(String jid);

    Job queryAllById(String jid);

    void addJob(Job job) throws JsonProcessingException;

    String queryJobType(String jid);

    List<Job> queryHotList();

    List<Map> queryType(String typeB);

    List<Map> queryCommpanyType();

    List<PublisherJob> queryPublisherJobsById(Integer pid);

    void removeJob(Integer pid, String jid);

    List<Map> recommendJob(User u);
    List<Map> queryTypeC();





}
