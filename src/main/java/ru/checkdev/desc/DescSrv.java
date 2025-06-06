package ru.checkdev.desc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@OpenAPIDefinition(info = @Info(title = "Desc - category and topic service", description = "Description"))
@SpringBootApplication
@EnableEurekaClient
public class DescSrv {

    public static void main(String[] args) {
        SpringApplication.run(DescSrv.class, args);
    }

}
