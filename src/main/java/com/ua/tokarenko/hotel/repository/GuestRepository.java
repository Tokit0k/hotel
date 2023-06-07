package com.ua.tokarenko.hotel.repository;

import com.ua.tokarenko.hotel.domain.Guest;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
    Optional<Guest> findByName(String name);
    Optional<Guest> findByPassport(String passport);
}