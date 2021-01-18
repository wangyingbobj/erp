package com.erp.main;


import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableSwagger2Doc
@EnableEurekaClient
@SpringBootApplication(scanBasePackages="com.erp")
@MapperScan("com.erp.main.mapper")
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
        System.out.println("http://localhost:6100/swagger-ui.html 可以用啦");
    }

}
