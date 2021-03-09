package pq.empm.dao;

import org.apache.ibatis.annotations.Param;
import pq.empm.model.Hot;

import java.util.List;
import java.util.Map;

public interface HotMapper {

    int insert(Hot record);

    List<Map> selectHotIndustry();

    List<Map> selectHotJobType();

    List<Map> selectHotCommpany();

    List<Map> selectHotArea();

    int selectClickTimesByType(String text);

    List<String> queryTop(@Param("start") Integer start,@Param("end") Integer end);
}