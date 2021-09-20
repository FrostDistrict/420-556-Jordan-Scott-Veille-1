package com.scott.reserved.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;
import java.util.List;

@Data
@Document(collection = "restaurants")
public class Restaurant extends BaseEntity {
    @Size(min = 3, max = 70)
    private String name;

    @Size(min = 3, max = 250)
    private String description;

    private String phone1;

    private String phone2;

    private int capacity;

    private List<Location> locations;

    private Schedule schedule;
}
