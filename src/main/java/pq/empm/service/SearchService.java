package pq.empm.service;

import pq.empm.model.Job;
import pq.empm.vo.SearchCondition;

import java.util.List;

public interface SearchService {
    List<Job> search(SearchCondition searchCondition);
}
