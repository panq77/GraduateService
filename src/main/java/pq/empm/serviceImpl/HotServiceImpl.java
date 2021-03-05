package pq.empm.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pq.empm.dao.HotMapper;
import pq.empm.service.HotService;
import pq.empm.util.MapperUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class HotServiceImpl implements HotService {
    @Autowired
    private HotMapper hotMapper;

    @Override
    public List<Map> query(String text) {
        List<Map> hots = new ArrayList<>();
        switch (text){
            case "热门行业top" :
                //hots=hotMapper.selectHotIndustry();
                break;
            case "热门岗位类型top":
                hots=hotMapper.selectHotJobType();
                break;
            case  "热门企业top"  :
                hots=hotMapper.selectHotCommpany();
                break;
            case  "热门地区"  :
                hots=hotMapper.selectHotArea();
                break;
        }

        return hots;
    }

    @Override
    public int queryClickTimesByType(String text) {

          int clickNum=hotMapper.selectClickTimesByType(text);
          return clickNum;
    }
}
