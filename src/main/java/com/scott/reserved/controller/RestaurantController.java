package com.scott.reserved.controller;

import com.scott.reserved.model.Restaurant;
import com.scott.reserved.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDate;

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

    @GetMapping("/getslots")
    public ResponseEntity<?> getAvailableTimeSlots(@Valid @RequestParam String id, String date){
        return ResponseEntity.ok(
                restaurantService.getAvailableTimeSlots(id, date)
        );
    }
}
