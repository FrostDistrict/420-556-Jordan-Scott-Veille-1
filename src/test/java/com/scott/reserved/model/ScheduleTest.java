package com.scott.reserved.model;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import static org.assertj.core.api.Assertions.*;

public class ScheduleTest {

    @Test
    public void testAddDay() {
        //Arrange
        Schedule schedule = new Schedule();

        //Act
        schedule.setOpeningClosingTimes(
                "lundi",
                LocalTime.of(8,0),
                LocalTime.of(17, 0));

        //Assert
        assertThat(schedule.getDay("lundi"))
                .isEqualTo(
                        new Schedule.Day(
                                LocalTime.of(8,0),
                                LocalTime.of(17, 0)));
    }
}
