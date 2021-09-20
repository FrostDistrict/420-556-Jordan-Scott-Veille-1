package com.scott.reserved.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Document(collection = "locations")
public class Location extends BaseEntity {
    @NotBlank
    @Size(min = 2, max = 300)
    private String address;

    @NotBlank
    @Size(min = 2, max = 250)
    private String city;

    @NotBlank
    @Size(min = 2, max = 250)
    private String province;
}



