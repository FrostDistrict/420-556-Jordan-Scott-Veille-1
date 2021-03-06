package com.scott.reserved.repository;

import com.scott.reserved.model.Reservation;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends BaseRepository<Reservation, String> {

    List<Reservation> getReservationsByRestaurantIdAndDate(String restaurantId, LocalDate date);

    List<Reservation> getReservationsByClientId(String id);
}
