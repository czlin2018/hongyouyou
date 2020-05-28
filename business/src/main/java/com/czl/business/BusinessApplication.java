package com.czl.business;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@ComponentScan ( basePackages = {"com.czl.business"} )
@MapperScan ( "com.czl.business.mapper" )
public class BusinessApplication {

    public static void main (String[] args) {
        SpringApplication.run(BusinessApplication.class, args);
    }

}
