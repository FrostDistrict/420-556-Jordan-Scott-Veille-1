package com.scott.reserved.model;

import lombok.Data;

import java.time.LocalTime;

@Data
public class TimeSlot {
    private LocalTime time;
    private boolean isAvailable;

    public TimeSlot(LocalTime time, boolean isAvailable) {
        this.time = time;
        this.isAvailable = isAvailable;
    }

    public TimeSlot(){}
}
