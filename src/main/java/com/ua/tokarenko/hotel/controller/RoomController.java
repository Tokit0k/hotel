package com.ua.tokarenko.hotel.controller;

import com.ua.tokarenko.hotel.domain.Room;
import com.ua.tokarenko.hotel.dto.RoomDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ua.tokarenko.hotel.service.RoomService;

import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class RoomController {

    public final RoomService roomService;

    @GetMapping("/room")
    public List<RoomDto> findAll() {
        return roomService.findAll();
    }

    @GetMapping("/room/find/{price}")
    public RoomDto findByPrice(@PathVariable Long price) {
        return roomService.findByPrice();
    }

    @GetMapping("/room/find/{number_of_beds}")
    public RoomDto findByNumberOfBeds(@PathVariable Long number_of_beds) {
        return roomService.findByNumberOfBeds();
    }

    @GetMapping("/room/find/{isReservation}")
    public boolean findByIsReservation(@PathVariable boolean isReservation) {
        return roomService.findByIsReservation();
    }

    @PostMapping("/room")
    public ResponseEntity<Room> save(@PathVariable Room room) {
        return new ResponseEntity<>(roomService.save(room), HttpStatus.CREATED);
    }

    @PutMapping("/room/update/{id}")
    public Room update(@PathVariable Long id, @RequestBody Room room) {
        return roomService.update(id, room);
    }

    @DeleteMapping("/room/{id}")
    public void deleteRoom(@PathVariable Long id) {
        return roomService.deleteRoom(id);
    }
}
