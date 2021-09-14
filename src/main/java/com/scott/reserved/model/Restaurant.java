package com.scott.reserved.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;

@Data
@Document(collection = "restaurants")
public class Restaurant {

    @Id
    private String id;

    private String nom;

    private String adress;

    private String telephone;

    private int capacite_max;

    private LocalTime ouverture;

    private LocalTime fermeture;


}
