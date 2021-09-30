package com.scott.reserved.dto;

import com.scott.reserved.model.Reservation;
import com.scott.reserved.model.Restaurant;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ReservationDto {
    private LocalDate date;

    private LocalTime time;

    private int amount;

    private String restaurantId;

    private String clientId;

    private Restaurant restaurant;

    public ReservationDto(Reservation reservation, Restaurant restaurant) {
        this.date = reservation.getDate();
        this.time = reservation.getTime();
        this.amount = reservation.getAmount();
        this.restaurantId = reservation.getRestaurantId();
        this.clientId = reservation.getClientId();
        this.restaurant = restaurant;
    }

    public ReservationDto(){}
}
