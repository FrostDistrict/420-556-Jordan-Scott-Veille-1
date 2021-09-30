package com.scott.reserved.model;

import lombok.Data;
import lombok.ToString;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@ToString
@Data
public class Schedule {
    Map<String, Day> days = new HashMap<>();

    public void setOpeningClosingTimes(String dayOfWeek, LocalTime opening, LocalTime closing) {
        days.put(dayOfWeek, new Day(opening, closing));
    }

    public Day getDay(String day) {
        return days.get(day);
    }

    public LocalTime getOpening(String day) {
        return days.get(day).getOpening();
    }

    public LocalTime getClosing(String day) {
        return days.get(day).getClosing();
    }

    public Schedule(){}

    @ToString
    @Data
    static class Day{
        LocalTime opening;
        LocalTime closing;

        public Day(LocalTime opening, LocalTime closing) {
            this.opening = opening;
            this.closing = closing;
        }


    }
}


