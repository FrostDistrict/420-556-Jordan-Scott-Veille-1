package com.scott.reserved.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "schedules")
public class Schedule extends BaseEntity {
    List<Day> days = new ArrayList<>(7);
}

class Day{
    LocalTime opening;
    LocalTime closing;
}
