package com.ua.tokarenko.hotel.service;

import com.ua.tokarenko.hotel.repository.GuestRepository;
import com.ua.tokarenko.hotel.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import com.ua.tokarenko.hotel.domain.Guest;
import com.ua.tokarenko.hotel.dto.GuestDto;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GuestService {

    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;
    public List<GuestDto> findAll() {
        return guestRepository.findAll()
                .stream()
                .map(guest -> GuestDto
                        .builder()
                        .id(guest.getId())
                        .name(guest.getName())
                        .surname(guest.getSurname())
                        .passport(guest.getPassport())
                        .phoneNumber(guest.getPhoneNumber())
                        .build())
                .collect(Collectors.toList());
    }

    public GuestDto findById(Long id) {
        Optional<Guest> guestOptional = guestRepository.findById(id);
        if (guestOptional.isPresent()) {
            return GuestDto
                    .builder()
                    .id(guestOptional.get().getId())
                    .name(guestOptional.get().getName())
                    .surname(guestOptional.get().getSurname())
                    .passport(guestOptional.get().getPassport())
                    .phoneNumber(guestOptional.get().getPhoneNumber())
                    .build();
        } else {
            throw new RuntimeException("Guest not found");
        }
    }

    public GuestDto findByName(String name) {
        Optional<Guest> guestOptional = guestRepository.findByName(name);
        if (guestOptional.isPresent()) {
            return GuestDto
                    .builder()
                    .id(guestOptional.get().getId())
                    .name(guestOptional.get().getName())
                    .surname(guestOptional.get().getSurname())
                    .passport(guestOptional.get().getPassport())
                    .phoneNumber(guestOptional.get().getPhoneNumber())
                    .build();
        } else {
            throw new RuntimeException("Guest not found");
        }
    }

    public GuestDto findByPassport(String passport) {
        Optional<Guest> guestOptional = guestRepository.findByPassport(passport);
        if (guestOptional.isPresent()) {
            return GuestDto
                    .builder()
                    .id(guestOptional.get().getId())
                    .name(guestOptional.get().getName())
                    .surname(guestOptional.get().getSurname())
                    .passport(guestOptional.get().getPassport())
                    .phoneNumber(guestOptional.get().getPhoneNumber())
                    .build();
        } else {
            throw new RuntimeException("Guest not found");
        }
    }

    public Guest save(Guest guest) {
        if (guest.getReservations() != null) {
            for (var reservation : guest.getReservations()){
                reservationRepository.save(reservation);
            }
        }
        return guestRepository.save(guest);
    }

    public Guest update(Long id, Guest guest) {
        Optional<Guest> guestOptional = guestRepository.findById(id);
        if (guestOptional.isPresent()) {
            Guest updatedGuest = guestOptional.get();
            updatedGuest.setName(guest.getName());
            updatedGuest.setSurname(guest.getSurname());
            updatedGuest.setPhoneNumber(guest.getPhoneNumber());
            return guestRepository.save(updatedGuest);
        } else {
            throw new RuntimeException("Guest not found");
        }
    }

    public void deleteGuest(Long id) {
        Optional<Guest> guestOptional = guestRepository.findById(id);
        if (guestOptional.isPresent()) {
            Guest guestDelete = guestOptional.get();
            guestRepository.delete(guestDelete);
        } else {
            throw new RuntimeException("Guest not fount");
        }
    }
}