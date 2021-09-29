package com.scott.reserved.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;

@Data
@Document(collection = "clients")
public class Client extends BaseEntity {
    private String name;

    private String lastName;

    @Email
    private String email;

    private String phoneNb;

    public Client(String name, String lastName, @Email String email, String phoneNb) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNb = phoneNb;
    }

    public Client(){}
}
