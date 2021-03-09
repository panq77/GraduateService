package pq.empm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pq.empm.dao.JobTypeSituationMapper;
import pq.empm.ex.NoMailForType;
import pq.empm.service.SituationService;

import java.util.List;
import java.util.Map;

@Service
public class SituationServiceImpl implements SituationService {
    @Autowired
    private JobTypeSituationMapper mapper;
    @Override
    public List<Map> query(String text) {
        List<Map> maps=mapper.selectSituation(text);
        if (maps.size()==0){
            throw new NoMailForType("还没有任何数据");
        }
        return maps;
    }
}
