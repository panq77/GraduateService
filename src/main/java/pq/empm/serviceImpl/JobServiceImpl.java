package pq.empm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pq.empm.dao.HotMapper;
import pq.empm.dao.JobMapper;
import pq.empm.model.Job;
import pq.empm.service.JobService;

import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class JobServiceImpl  implements JobService {

    @Autowired
    private JobMapper jobMapper;
    @Override
    public List<Job> queryById(Integer pid) {
        return  jobMapper.queryById(pid);

    }

    @Override
    public Job queryDetailById(String jid) {

        return jobMapper.queryDetailById(jid);

    }

    @Override
    public Job queryAllById(String jid) {
        return jobMapper.queryAllById(jid);
    }

    @Override
    public void addJob(Job job) {
        int count = queryCount();
        job.setJid((count+1)+"");
        jobMapper.insert(job);

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
        int start=new Random().nextInt(5);
        int end=start+5;
         List<String> jidList=hotMapper.queryTop(start,end);
        return jobMapper.queryHotJob(jidList);
    }

    @Override
    public List<Map> queryType(String typeB) {
        List<Map> maps = jobMapper.queryTypeCByTypeB(typeB);

          return  maps;
    }

    @Override
    public List<Map> queryCommpanyType() {
        return jobMapper.queryCommpanyType();

    }

    private int queryCount(){
        return jobMapper.queryCount();
    }


}
