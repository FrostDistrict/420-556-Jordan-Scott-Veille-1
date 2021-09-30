package com.scott.reserved.service;

import com.scott.reserved.dto.ReservationDto;
import com.scott.reserved.model.Reservation;
import com.scott.reserved.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService extends CrudService<Reservation, String> {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    public void configureGenericService() {
        setBaseRepository(reservationRepository);
    }

    public List<Reservation> getAllByRestaurantIdAndDay(String restaurantId, LocalDate date) {
        return reservationRepository.getReservationsByRestaurantIdAndDate(restaurantId, date);
    }

    public List<ReservationDto> getAllByClientId(String id) {
        List<ReservationDto> reservationDtos = new ArrayList<>();
        reservationRepository.getReservationsByClientId(id).forEach(reservation -> {
            reservationDtos.add(new ReservationDto(reservation, restaurantService.getOneByID(reservation.getRestaurantId()).get()));
        });
        return reservationDtos;
    }
}
