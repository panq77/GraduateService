package pq.empm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pq.empm.service.HotService;
import pq.empm.service.SituationService;
import pq.empm.util.MapperUtil;
import pq.empm.vo.JsonResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/situation")
public class SituationController {
    @Autowired
    private SituationService situationService;
    @Autowired
    private HotService hotService;
    @RequestMapping("/query_situation")
    public JsonResult<List<String>> query(String text){
        List<Map> maps=situationService.query(text);
        List<String> lists=new ArrayList<>();
        int clickTimes=hotService.queryClickTimesByType(text);
        for (Map map:maps){
            try {
                String jsonMap = MapperUtil.MP.writeValueAsString(map.put("clickTimes",clickTimes));
                lists.add(jsonMap);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return  new JsonResult<>(lists);
    }

}
