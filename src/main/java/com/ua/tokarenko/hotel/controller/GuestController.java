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

    @GetMapping("/Guest")
    public List<GuestDto> findAll() {
        return guestService.findAll();
    }

    @GetMapping("/Guest/{id}")
    public GuestDto findById(@PathVariable Long id) {
        return guestService.findById(id);
    }

    @GetMapping("/Guest/find/{name}")
    public GuestDto findByName(@PathVariable String name) {
        return guestService.findByName(name);
    }

    @GetMapping("/Guest/find/{passport}")
    public GuestDto findByPassport(@PathVariable String passport) {
        return guestService.findByPassport(passport);
    }

    @PostMapping("/Guest")
    public ResponseEntity<Guest> save(@RequestBody Guest guest) {
        return new ResponseEntity<>(guestService.save(guest), HttpStatus.CREATED);
    }

    @PutMapping("/Guest/update/{id}")
    public Guest update(@PathVariable Long id, @RequestBody Guest guest) {
        return guestService.update(id, guest);
    }

    @DeleteMapping("/Guest/{id}")
    public void deleteGuest(@PathVariable Long id){
        guestService.deleteGuest(id);
    }
}
