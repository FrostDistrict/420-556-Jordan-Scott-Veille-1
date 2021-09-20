package com.scott.reserved.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class Location {
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



