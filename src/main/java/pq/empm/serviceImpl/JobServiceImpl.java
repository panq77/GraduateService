package pq.empm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pq.empm.dao.JobMapper;
import pq.empm.model.Job;
import pq.empm.service.JobService;

import java.util.List;

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

    private int queryCount(){
        return jobMapper.queryCount();
    }

}
