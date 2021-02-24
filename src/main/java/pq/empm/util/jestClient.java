package pq.empm.util;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Repository
public class jestClient {
    @Bean
    public JestClient getJestCline(){
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig
                .Builder("http://192.168.229.132:9200")
                .multiThreaded(true)
                .build());

        return  factory.getObject();
    }


}
