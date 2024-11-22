package za.co.protogen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaServer
public class carApplication {
    private static final Logger logger = LoggerFactory.getLogger(carApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(carApplication.class,args);
        logger.info("Example log from {}", carApplication.class.getSimpleName());
    }
}
