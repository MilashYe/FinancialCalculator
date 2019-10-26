package kpi.studying.coursework.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class DBConfig {

    @Bean
    public MongoClient mongo() {
        return new MongoClient("localhost");
    }

}
