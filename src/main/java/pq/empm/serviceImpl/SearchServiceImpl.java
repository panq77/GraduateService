package pq.empm.serviceImpl;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Search;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pq.empm.ex.JobNotExist;
import pq.empm.model.Job;
import pq.empm.service.SearchService;
import pq.empm.util.MapperUtil;
import pq.empm.util.SearchCondition;
import pq.empm.vo.EsJob;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    private static String indexName="job";
    private static String type="job";
    @Autowired
    private JestClient jestClient;

    @Override
    public List<Job> search(SearchCondition searchCondition) {
        ArrayList<Job> jobs = new ArrayList<>();
        Integer page = searchCondition.getPage();
        Integer rows = searchCondition.getRows();
        int size=rows;
        int from=((page-1)*rows)+1;
        SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
        searchSourceBuilder.from(from);
        searchSourceBuilder.size(size);
        BoolQueryBuilder queryBuilder= QueryBuilders.boolQuery();
        if (searchCondition.getText()!=null){
            System.out.println(!"".equals(searchCondition.getText()));
            queryBuilder.must(QueryBuilders.matchQuery("jname",searchCondition.getText()));
        }
        if (searchCondition.getType()!=null){
            queryBuilder.must(QueryBuilders.matchQuery("TypeC",searchCondition.getType()));
        }
        if (searchCondition.getEducation()!=null){
            queryBuilder.must(QueryBuilders.matchQuery("education",searchCondition.getEducation()));
        }
        if (searchCondition.getJarea()!=null){
            queryBuilder.must(QueryBuilders.matchQuery("jarea",searchCondition.getJarea()));
        }
        if (searchCondition.getSalary()!=null){
            queryBuilder.must(QueryBuilders.matchQuery("salary",searchCondition.getSalary()));
        }
        if (searchCondition.getJcommpanyType()!=null){
            queryBuilder.must(QueryBuilders.matchQuery("jcommpanyType",searchCondition.getJcommpanyType()));
        }
        if (searchCondition.getJcommpanyScale()!=null){
            queryBuilder.must(QueryBuilders.matchQuery("commpanyScale",searchCondition.getJcommpanyScale()));
        }
        searchSourceBuilder.query(queryBuilder);
        Search search=new Search.Builder(searchSourceBuilder.toString()).addIndex(indexName).addType(type).build();
        try {
            JestResult jestResult=jestClient.execute(search);

            List<EsJob> esJobs = jestResult.getSourceAsObjectList(EsJob.class);
            for (EsJob esJob:esJobs){
                Job job = MapperUtil.MP.readValue(esJob.getData(), Job.class);
                jobs.add(job);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        if(jobs.size()==0){
            throw new JobNotExist("没有下一页了");
        }
        return  jobs;
    }
}
