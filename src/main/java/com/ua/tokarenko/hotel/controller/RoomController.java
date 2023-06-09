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

    @GetMapping("/Room/find/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomService.findById(id);
    }

    @GetMapping("/Room/find/{price}")
    public RoomDto findByPrice(@PathVariable Long price) {
        return roomService.findByPrice(price);
    }

    @GetMapping("/Room/find/{numberOfBeds}")
    public RoomDto findByNumberOfBeds(@PathVariable Long numberOfBeds) {
        return roomService.findByNumberOfBeds(numberOfBeds);
    }

    @GetMapping("/Room/find/{isReservation}")
    public boolean findByIsReservation(@PathVariable boolean isReservation) {
        return roomService.findByIsReservation(isReservation);
    }

    @PostMapping("/room")
    public ResponseEntity<Room> save(@RequestBody Room room) {
        return new ResponseEntity<>(roomService.save(room), HttpStatus.CREATED);
    }

    @PutMapping("/Room/update/{id}")
    public Room update(@PathVariable Long id, @RequestBody Room room) {
        return roomService.update(id, room);
    }

    @DeleteMapping("/Room/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
    }
}
