package pq.empm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("pq.empm.dao")
@SpringBootApplication
public class EmpmApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpmApplication.class, args);
    }

}
