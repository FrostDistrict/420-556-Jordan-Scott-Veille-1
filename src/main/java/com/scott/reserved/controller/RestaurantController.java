package com.scott.reserved.controller;

import com.scott.reserved.model.Restaurant;
import com.scott.reserved.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
@RequestMapping("/restaurant")
public class RestaurantController extends GenericController<Restaurant, String> {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    public void configureGenericController() {
        setCrudService(restaurantService);
    }
}
