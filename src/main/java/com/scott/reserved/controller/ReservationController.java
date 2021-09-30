package com.scott.reserved.controller;

import com.scott.reserved.model.Reservation;
import com.scott.reserved.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@CrossOrigin
@RequestMapping("/reservation")
public class ReservationController extends GenericController<Reservation, String> {

    @Autowired
    private ReservationService reservationService;
    
    @Autowired
    public void configureGenericController () {
        setCrudService(reservationService);
    }

    @GetMapping("/getallbyclientid")
    public ResponseEntity<?> getAllReservationsByClientId(@Valid @RequestParam String id){
        return ResponseEntity.ok(
                reservationService.getAllByClientId(id)
        );
    }
}
