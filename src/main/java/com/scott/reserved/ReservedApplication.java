package com.scott.reserved;

import com.scott.reserved.model.Client;
import com.scott.reserved.model.Restaurant;
import com.scott.reserved.repository.ClientRepository;
import com.scott.reserved.repository.RestaurantRepository;
import com.scott.reserved.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;

@SpringBootApplication
@EnableMongoRepositories("com.scott.reserved.repository")
@ComponentScan(value = "com.scott.reserved.*")
public class ReservedApplication implements CommandLineRunner {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private ClientRepository clientRepository;

    public static void main(String[] args) {
        SpringApplication.run(ReservedApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Restaurant rest1 = new Restaurant("toto", "restorante", "test", "test", "test@gmail.com", 2);
        Restaurant rest2 = new Restaurant("toto", "restorante", "test", "test", "test@gmail.com", 2);
        Restaurant rest3 = new Restaurant("toto", "restorante", "test", "test", "test@gmail.com", 2);
        Restaurant rest4 = new Restaurant("toto", "restorante", "test", "test", "test@gmail.com", 2);
        Restaurant rest5 = new Restaurant("toto", "restorante", "test", "test", "test@gmail.com", 2);
        Restaurant rest6 = new Restaurant("toto", "restorante", "test", "test", "test@gmail.com", 2);

        Client cli1 = new Client("toto", "lastname", "toto@mail.com", "514-444-4442");
        Client cli2 = new Client("toto", "lastname", "toto@mail.com", "514-444-4442");
        Client cli3 = new Client("toto", "lastname", "toto@mail.com", "514-444-4442");
        Client cli4 = new Client("toto", "lastname", "toto@mail.com", "514-444-4442");

        clientRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4));
        restaurantRepository.saveAll(Arrays.asList(rest1, rest2, rest3, rest4, rest5, rest6));
    }
}
