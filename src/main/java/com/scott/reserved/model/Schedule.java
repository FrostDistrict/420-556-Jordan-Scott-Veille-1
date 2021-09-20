package com.scott.reserved.model;

import lombok.Data;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@Data
public class Schedule {
    Map<String, Day> days = new HashMap<>();

}

@Data
class Day{
    LocalTime opening;
    LocalTime closing;

    public Day(LocalTime opening, LocalTime closing) {
        this.opening = opening;
        this.closing = closing;
    }
}
