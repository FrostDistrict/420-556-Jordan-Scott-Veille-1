package com.scott.reserved.service;

import com.scott.reserved.model.Reservation;
import com.scott.reserved.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ReservationService extends CrudService<Reservation, String> {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    public void configureGenericService() {
        setBaseRepository(reservationRepository);
    }

    public List<Reservation> getAllByRestaurantIdAndDay(String restaurantId, LocalDate date) {
        return reservationRepository.getReservationsByRestaurantIdAndDate(restaurantId, date);
    }
}
