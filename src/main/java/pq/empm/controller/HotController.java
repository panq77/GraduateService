package pq.empm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pq.empm.service.HotService;
import pq.empm.util.MapperUtil;
import pq.empm.vo.JsonResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hot")
public class HotController {
    @Autowired
    private HotService hotService;
    @RequestMapping("/query_hot")
    public JsonResult<List<String>> hotList(String text){
        List<Map> hots=hotService.query(text);
        List<String> lists=new ArrayList<>();
        for (Map map:hots){
            try {
                String jsonMap = MapperUtil.MP.writeValueAsString(map);
                lists.add(jsonMap);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return  new JsonResult<>(lists);
    }


}
