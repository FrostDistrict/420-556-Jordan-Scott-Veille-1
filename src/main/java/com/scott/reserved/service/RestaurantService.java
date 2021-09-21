package com.scott.reserved.service;

import com.scott.reserved.model.Restaurant;
import com.scott.reserved.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService extends CrudService<Restaurant, String> {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    public void configureGenericService() {
        setBaseRepository(restaurantRepository);
    }
}
