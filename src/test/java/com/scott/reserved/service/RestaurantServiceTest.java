package com.scott.reserved.service;

import com.scott.reserved.model.Restaurant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

@DataMongoTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RestaurantServiceTest {

    @Autowired
    ClientService clientService;

    @Autowired
    RestaurantService restaurantService;

    @Test
    void test() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("potato");

        Restaurant potato  = restaurantService.create(restaurant).get();

        System.out.println(potato);
        System.out.println(potato.getId());
    }
}
