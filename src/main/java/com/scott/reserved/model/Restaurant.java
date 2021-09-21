package com.scott.reserved.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
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

    @Email
    private String email;

    private int capacity;

    private List<Location> locations;

    private Schedule schedule;

    public Restaurant(@Size(min = 3, max = 70) String name, @Size(min = 3, max = 250) String description, String phone1, String phone2, @Email String email, int capacity) {
        this.name = name;
        this.description = description;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.email = email;
        this.capacity = capacity;
    }

    public Restaurant() {

    }
}
