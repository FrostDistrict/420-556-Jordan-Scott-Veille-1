package com.scott.reserved.service;

import com.scott.reserved.model.Reservation;
import com.scott.reserved.model.Restaurant;
import com.scott.reserved.model.Schedule;
import com.scott.reserved.model.TimeSlot;
import com.scott.reserved.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService extends CrudService<Restaurant, String> {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    public void configureGenericService() {
        setBaseRepository(restaurantRepository);
    }

    public List<TimeSlot> getAvailableTimeSlots(String restaurantID, String date){
        Restaurant restaurant;
        LocalDate localDate = formatDate(date);
        if (restaurantRepository.existsById(restaurantID)) {
            restaurant = getOneByID(restaurantID).get();
            LocalTime opening = restaurant.getSchedule().getOpening(localDate.getDayOfWeek().name());
            LocalTime closing = restaurant.getSchedule().getClosing(localDate.getDayOfWeek().name());
            List<Reservation> reservations = reservationService.getAllByRestaurantIdAndDay(restaurantID, localDate);

            List<TimeSlot> timeSlotArray = buildTimeSlotArray(opening, closing);
            for (TimeSlot timeSlot: timeSlotArray){
                int currentAmount = 0;
                for (Reservation reservation: reservations){
                    System.out.println(reservation);
                    if (timeSlot.getTime().isAfter(reservation.getTime()) && timeSlot.getTime().isBefore(reservation.getTime().plusHours(2))){
                        currentAmount+= reservation.getAmount();
                    }
                }
                if (currentAmount >= restaurant.getCapacity()) {
                    timeSlot.setAvailable(false);
                }
            }
            return timeSlotArray;
        }
        return null;
    }

    public LocalDate formatDate(String date){
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public List<TimeSlot> buildTimeSlotArray(LocalTime opening, LocalTime closing) {
        LocalTime time = opening;
        List<TimeSlot> timeSlotArray = new ArrayList<>();
        while(time.isBefore(closing.minusHours(2))) {
            timeSlotArray.add(new TimeSlot(time, true));
            time = time.plusMinutes(15);
        }
        return timeSlotArray;
    }
}
