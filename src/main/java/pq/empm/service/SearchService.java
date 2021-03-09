package pq.empm.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import pq.empm.model.Job;
import pq.empm.vo.SearchCondition;

import java.util.List;

public interface SearchService {
    List<Job> search(SearchCondition searchCondition);

    void addJob(Job job) throws JsonProcessingException;

    void removeJob(String jid);
}
