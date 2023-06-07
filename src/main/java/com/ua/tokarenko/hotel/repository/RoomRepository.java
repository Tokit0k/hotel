package com.ua.tokarenko.hotel.repository;

import com.ua.tokarenko.hotel.domain.Room;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findByPrice(Long price);

    Optional<Room> findByNumberOfBeds(Long numberOfBeds);
}