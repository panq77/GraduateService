package pq.empm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pq.empm.model.Job;
import pq.empm.model.User;
import pq.empm.service.SearchService;
import pq.empm.util.SearchCondition;
import pq.empm.vo.JsonResult;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController extends BaseController {
    @Autowired
    private SearchService searchService;

    @RequestMapping("/query")
    public JsonResult<List<Job>> search(HttpSession session,SearchCondition searchCondition) {
        User user = (User) session.getAttribute("username");
        /**
         * 如果没有选择地区，则默认以用户期望工作地区为条件
         * */
        if (searchCondition.getJarea()==null){
            searchCondition.setJarea(user.getExpectedEara());
        }

        List<Job> jobs=searchService.search(searchCondition);

      return new JsonResult<>(jobs);
    }
}
