package pq.empm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pq.empm.model.Job;
import pq.empm.model.User;
import pq.empm.service.SearchService;
import pq.empm.util.MapperUtil;
import pq.empm.vo.SearchCondition;
import pq.empm.vo.JsonResult;
import pq.empm.vo.LogData;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/search")
public class SearchController extends BaseController {
    @Autowired
    private SearchService searchService;

    @RequestMapping("/query")
    public JsonResult<List<Job>> search(HttpSession session, SearchCondition searchCondition) throws JsonProcessingException {
        List<Job> jobs = searchService.search(searchCondition);
        /**
         * 记录日志系统
         * */
        User user = (User) session.getAttribute("username");
        log.info((MapperUtil.MP.writeValueAsString(new LogData(user.getUid(), user.getUname(), user.getAge(),
                user.getGender(), user.getExpectedJob(), user.getExpectedEara(),
                user.getEducation(), user.getHasExperience().toString(), "query_job",
                searchCondition.getType(), searchCondition.getSalary(),
                searchCondition.getJcommpanyType(), searchCondition.getJcommpanyScale(),
                searchCondition.getJarea(), searchCondition.getText()
        ))));
        return new JsonResult<>(jobs);
    }


}
