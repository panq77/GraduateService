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
    public JsonResult<List<Map>> hotList(String text){
        List<Map> hots=hotService.query(text);
        return  new JsonResult<>(hots);
    }
}
