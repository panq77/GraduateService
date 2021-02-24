package pq.empm.dao;

import pq.empm.model.Hot;

import java.util.List;
import java.util.Map;

public interface HotMapper {

    int insert(Hot record);

    List<Map> selectHotIndustry();

    List<Map> selectHotJobType();

    List<Map> selectHotCommpany();

    List<Map> selectHotArea();
}