package com.scott.reserved;

import com.scott.reserved.model.Restaurant;
import com.scott.reserved.service.ClientService;
import com.scott.reserved.service.RestaurantService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReservedApplicationTests {

    @Autowired
    ClientService clientService;

    @Autowired
    RestaurantService restaurantService;

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("potato");

        Restaurant potato  = restaurantService.create(restaurant).get();

        System.out.println(potato);
        System.out.println(potato.getId());
    }

}
