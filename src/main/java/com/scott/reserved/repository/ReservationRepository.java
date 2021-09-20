package com.scott.reserved.repository;

import com.scott.reserved.model.Reservation;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends BaseRepository<Reservation, String> {
}
