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
import pq.empm.vo.SearchCondition;
import pq.empm.vo.EsJob;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    private static String indexName="job";
    private static String type="job";
    @Autowired(required = false)
    private JestClient jestClient;

    @Override
    public List<Job> search(SearchCondition searchCondition) {
        String jcommpanyType = searchCondition.getJcommpanyType();
        String education = searchCondition.getEducation();
        String salary = searchCondition.getSalary();
        String jarea = searchCondition.getJarea();
        String type = searchCondition.getType();
        String text = searchCondition.getText();
        String jcommpanyScale = searchCondition.getJcommpanyScale();
        List<Job> jobs = new ArrayList<>();
        Integer page = searchCondition.getPage();
        Integer rows = searchCondition.getRows();
        int size=rows;
        int from=((page-1)*rows)+1;
        SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
        searchSourceBuilder.from(from);
        searchSourceBuilder.size(size);
        BoolQueryBuilder queryBuilder= new BoolQueryBuilder();
        if (!"空".equals(text)){
            queryBuilder.must(QueryBuilders.matchQuery("jname",text));
        }

        if (!"空".equals(type)){
                queryBuilder.must(QueryBuilders.matchQuery("TypeC", type));
        }
        if (!"不限".equals(education)){
            queryBuilder.must(QueryBuilders.matchQuery("education",education));
        }
        if (!"全国".equals(jarea)){
            queryBuilder.must(QueryBuilders.matchQuery("jarea",jarea));
        }
        if (!"不限".equals(salary)){
            queryBuilder.must(QueryBuilders.matchQuery("salary",salary));
        }
        if (!"不限".equals(jcommpanyType)){
            queryBuilder.must(QueryBuilders.matchQuery("jcommpanyType",jcommpanyType));
        }
        if (!"不限".equals(jcommpanyScale)){
            queryBuilder.must(QueryBuilders.matchQuery("commpanyScale",jcommpanyScale));
        }
        searchSourceBuilder.query(queryBuilder);
        Search search=new Search.Builder(searchSourceBuilder.toString()).addIndex(indexName).addType(SearchServiceImpl.type).build();
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
