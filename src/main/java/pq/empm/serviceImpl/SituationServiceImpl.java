package pq.empm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pq.empm.dao.JobTypeSituationMapper;
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
        return maps;
    }
}
