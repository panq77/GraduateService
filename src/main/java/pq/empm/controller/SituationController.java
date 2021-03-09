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
import java.util.HashMap;
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
    public JsonResult<List<Map>> query(String text){
        System.out.println(111);
        List<Map> maps=situationService.query(text);

        int clickTimes=hotService.queryClickTimesByType(text);

        HashMap<String, String> hashMap = new HashMap<>();
           hashMap.put("clickTimes", String.valueOf(clickTimes));
        maps.add(hashMap);
        System.out.println(maps);
        return  new JsonResult<>(maps);
    }

}
