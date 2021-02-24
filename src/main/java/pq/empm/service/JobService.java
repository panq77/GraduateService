package pq.empm.service;

import pq.empm.model.Job;

import java.util.List;

public interface JobService {

    List<Job> queryById(Integer pid);

    Job queryDetailById(String jid);

    Job queryAllById(String jid);

    void addJob(Job job);

}
