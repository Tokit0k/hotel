package com.ua.tokarenko.hotel.repository;

import com.ua.tokarenko.hotel.domain.Reservation;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}