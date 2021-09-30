package com.scott.reserved.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.time.LocalTime;

@Data
@Document(collection = "reservations")
public class Reservation extends BaseEntity {
    @NotBlank
    private LocalTime time;

    @NotBlank
    private int amount;

    @NotBlank
    private String restaurantID;

    @NotBlank
    private String clientID;
}
