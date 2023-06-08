package com.ua.tokarenko.hotel.controller;

import lombok.RequiredArgsConstructor;
import com.ua.tokarenko.hotel.dto.GuestDto;
import org.springframework.http.HttpStatus;
import com.ua.tokarenko.hotel.domain.Guest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ua.tokarenko.hotel.service.GuestService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GuestController {
    private final GuestService guestService;

    @GetMapping("/guest")
    public List<GuestDto> findAll() {
        return guestService.findAll();
    }

    @GetMapping("/guest/{id}")
    public GuestDto findById(@PathVariable Long id) {
        return guestService.findById(id);
    }

    @GetMapping("/find/{name}")
    public GuestDto findByName(@PathVariable String name) {
        return guestService.findByName(name);
    }

    @GetMapping("/find-by-passport/{passport}")
    public GuestDto findByPassport(@PathVariable String passport) {
        return guestService.findByPassport(passport);
    }

    @PostMapping("/guest")
    public ResponseEntity<Guest> save(@RequestBody Guest guest) {
        return new ResponseEntity<>(guestService.save(guest), HttpStatus.CREATED);
    }

    @PutMapping("/guest/update/{id}")
    public Guest update(@PathVariable Long id, @RequestBody Guest guest) {
        return guestService.update(id, guest);
    }

    @DeleteMapping("/guest/{id}")
    public void deleteGuest(@PathVariable Long id){
        guestService.deleteGuest(id);
    }
}

