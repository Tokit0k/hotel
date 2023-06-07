package com.ua.tokarenko.hotel.repository;

import com.ua.tokarenko.hotel.domain.Room;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}