package pq.empm.dao;

import pq.empm.model.Job;

import java.util.List;

public interface JobMapper {
    int insert(Job record);
    Job queryAllById(String jid);
    Job queryDetailById(String jid);
    List<Job> queryById(int pid);
    int queryCount();
    List<Job> queryAll();
}