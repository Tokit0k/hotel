package com.ua.tokarenko.hotel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import com.ua.tokarenko.hotel.dto.ReservationDto;
import com.ua.tokarenko.hotel.domain.Reservation;
import com.ua.tokarenko.hotel.service.ReservationService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    public final ReservationService reservationService;

    @GetMapping("/reservation")
    public List<ReservationDto> findAll() {
        return reservationService.findAll();
    }

    @GetMapping("/reservation/find/{id}")
    public ReservationDto findById(@PathVariable Long id) {
        return reservationService.findById(id);
    }

    @GetMapping("/reservation/find/{reservationDate}")
    public boolean findByReservationDate(@PathVariable Date reservationDate){
        return reservationService.findByReservationDate(reservationDate);
    }

    @PostMapping("/reservation")
    public ResponseEntity<Reservation> save(@RequestBody Reservation reservation) {
        return new ResponseEntity<>(reservationService.save(reservation), HttpStatus.CREATED);
    }

    @PutMapping("/reservation/update/{id}")
    public Reservation update (@PathVariable Long id,@RequestBody Reservation reservation){
    return reservationService.update(id, reservation);
    }

    @DeleteMapping("/reservation/{id}")
    public void deleteReservation (@PathVariable Long id){
        reservationService.deleteReservation(id);
    }
}
