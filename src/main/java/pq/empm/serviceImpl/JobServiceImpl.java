package pq.empm.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pq.empm.dao.HotMapper;
import pq.empm.dao.JobMapper;
import pq.empm.dao.ResumeMapper;
import pq.empm.ex.ResumeNotHandle;
import pq.empm.model.Job;
import pq.empm.model.Resume;
import pq.empm.model.User;
import pq.empm.service.JobService;
import pq.empm.service.SearchService;
import pq.empm.vo.PublisherJob;
import pq.empm.vo.SearchCondition;

import java.time.LocalDate;
import java.util.*;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobMapper jobMapper;

    @Override
    public List<Job> queryById(Integer pid) {
        return jobMapper.queryById(pid);

    }

    @Override
    public Job queryDetailById(String jid) {

        return jobMapper.queryDetailById(jid);

    }

    @Override
    public Job queryAllById(String jid) {
        return jobMapper.queryAllById(jid);
    }

    @Autowired
    private SearchService searchService;

    @Override
    @Transactional
    public void addJob(Job job) throws JsonProcessingException {
        int max = queryMax();
        job.setJid((max + 1) + "");
        jobMapper.insert(job);
        searchService.addJob(job);

    }

    @Override
    public String queryJobType(String jid) {
        String typeC = jobMapper.queryJobType(jid);
        return typeC;
    }

    @Autowired
    private HotMapper hotMapper;

    @Override
    public List<Job> queryHotList() {
        int start = new Random().nextInt(5);
        int end = start + 5;
        List<String> jidList = hotMapper.queryTop(start, end);
        return jobMapper.queryHotJob(jidList);
    }

    @Override
    public List<Map> queryType(String typeB) {
        List<Map> maps = jobMapper.queryTypeCByTypeB(typeB);

        return maps;
    }

    @Override
    public List<Map> queryCommpanyType() {
        return jobMapper.queryCommpanyType();

    }

    @Override
    public List<PublisherJob> queryPublisherJobsById(Integer pid) {
        return jobMapper.queryPublisherJobsById(pid);
    }

    @Autowired
    private ResumeMapper resumeMapper;

    @Override
    @Transactional
    public void removeJob(Integer pid, String jid) {

        List<Resume> resumes = resumeMapper.queryResumeByPidAndJid(pid, jid);
        System.out.println(queryHotList());
        if (!resumes.isEmpty()) {
            throw new ResumeNotHandle("还有应聘信息未处理");
        }
        jobMapper.deleteByJid(jid);
        searchService.removeJob(jid);
    }


    /**
     * 获取用户搜索最多的key，根据key获取发布的岗位，然后招聘者的活跃度 来进行筛选
     * 如果为空 则用session中用户的信息 获取 期望岗位；
     * 如果为空  则推荐热门岗位  10- 20
     */
    @Override
    public List<Map> recommendJob(User u) {

        List<Map> maps = null;
        List<Map> keys = jobMapper.searchKey(u.getUid());
        System.out.println(keys);
        if (keys.size() != 0) {
            for (int i = 0; i < keys.size(); i++) {
                String key = (String) keys.get(i).get("key");
                maps = jobMapper.recommendJob(key, LocalDate.now().plusDays(-4).toString());
                if (maps!=null){
                    break;
                }
            }
        }
        if (maps==null){
            if (u.getExpectedJob() != null) {
                maps = jobMapper.recommendJob2Method(u.getExpectedJob());
            }
        }
        return maps;
    }

    @Override
    public List<Map> queryTypeC() {
        List<Map> maps=jobMapper.queryAllTypeC();
        return maps;
    }


    private int queryCount() {
        return jobMapper.queryCount();
    }

    private int queryMax() {
        return jobMapper.queryMax();
    }

}
