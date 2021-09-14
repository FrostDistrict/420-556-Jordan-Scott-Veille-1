package com.scott.reserved;

import com.scott.reserved.model.Restaurant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = Restaurant.class)
@ComponentScan(value = "com.scott.reserved.*")
public class ReservedApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservedApplication.class, args);
    }

}
