package pq.empm.dao;

import pq.empm.model.JobTypeSituation;

import java.util.List;
import java.util.Map;

public interface JobTypeSituationMapper {

    int insert(JobTypeSituation record);


    List<Map> selectSituation(String text);
}