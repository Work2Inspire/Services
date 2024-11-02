package za.co.protogen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ApplicationProperties {

//    eureka.client.serviceUrl.defaultZone="http://localhost:9102/eureka/"
//    eureka.client.register-with-eureka=true
//    eureka.client.fetch-registry=true
//
//    eureka.client.register-with-eureka=true  // Registers the service with Eureka
//    eureka.client.fetch-registry=true        // Fetches the registry from Eureka

// carService properties
    private int serverport=9102;

    public int returnport(){
        return serverport;
    }


}
