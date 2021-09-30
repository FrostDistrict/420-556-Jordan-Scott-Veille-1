package com.scott.reserved.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Document(collection = "reservations")
public class Reservation extends BaseEntity {
    @NotBlank
    private LocalDate date;

    @NotBlank
    private LocalTime localTime;

    @NotBlank
    private int amount;

    @NotBlank
    private String restaurantID;

    @NotBlank
    private String clientID;

    public Reservation(LocalDate date, LocalTime localTime, int amount, String restaurantID, String clientID) {
        this.date = date;
        this.localTime = localTime;
        this.amount = amount;
        this.restaurantID = restaurantID;
        this.clientID = clientID;
    }

    public Reservation(){}
}
