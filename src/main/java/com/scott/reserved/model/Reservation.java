package com.scott.reserved.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Document(collection = "reservations")
public class Reservation extends BaseEntity {
    @NotNull
    private LocalDate date;

    @NotNull
    private LocalTime time;

    @NotNull
    private int amount;

    @NotBlank
    private String restaurantId;

    @NotBlank
    private String clientId;

    public Reservation(LocalDate date, LocalTime time, int amount, String restaurantId, String clientId) {
        this.date = date;
        this.time = time;
        this.amount = amount;
        this.restaurantId = restaurantId;
        this.clientId = clientId;
    }

    public Reservation(){}
}
