package com.architecture.ddd.application.rest.clientapi.query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.architecture.ddd.*"})
@EntityScan("com.architecture.ddd.*")
@EnableJpaRepositories(basePackages = {"com.architecture.ddd.infrastructure.repository.*"})
@EnableMongoRepositories(basePackages = {"com.architecture.ddd.infrastructure.repository.*"})
public class ApplicationClientApiQuery {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationClientApiQuery.class, args);
    }

}