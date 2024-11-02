package za.co.protogen;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;


import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RestController;
import za.co.protogen.controller.carServiceApiController;

@RestController
@SpringBootApplication
public class clientApplication implements carServiceApiController.CarController {
    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String AppName;

    public static void main(String[] args) {
        SpringApplication.run(clientApplication.class,args);
    }

    @Override
    public String greeting() {
        return String.format(
                "Hello from '%s'!", eurekaClient.getApplication(AppName).getName());
    }
}