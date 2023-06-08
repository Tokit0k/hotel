package com.ua.tokarenko.hotel.service;

import com.ua.tokarenko.hotel.repository.ReservationRepository;
import com.ua.tokarenko.hotel.domain.Reservation;
import com.ua.tokarenko.hotel.dto.ReservationDto;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public List<ReservationDto> findAll() {
        return reservationRepository.findAll()
                .stream()
                .map(reservation -> ReservationDto
                        .builder()
                        .id(reservation.getId())
                        .checkIn(reservation.getCheckIn())
                        .checkOut(reservation.getCheckOut())
                        .reservationDate(reservation.getReservationDate())
                        .room(reservation.getRoom().toString())
                        .guest(reservation.getRoom().toString())
                        .build())
                .collect(Collectors.toList());


    }

    public ReservationDto findById(Long id) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        if (optionalReservation.isPresent()) {
            return ReservationDto
                    .builder()
                    .id(optionalReservation.get().getId())
                    .checkIn(optionalReservation.get().getCheckIn())
                    .checkOut(optionalReservation.get().getCheckOut())
                    .reservationDate(optionalReservation.get().getReservationDate())
                    .room(optionalReservation.get().getRoom().toString())
                    .guest(optionalReservation.get().getGuest().toString())
                    .build();
        } else {
            throw new RuntimeException("Reservation not found");
        }
    }

    public boolean findByReservationDate(Date reservationDate) {
        List<Reservation> optionalReservation = reservationRepository.findAll();
        for (Reservation reservation : optionalReservation) {
            if (reservation.getReservationDate().equals(reservationDate))
                return false;
        }
        return true;
    }

    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation update(Long id, Reservation reservation) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        if (reservationOptional.isPresent()) {
            Reservation updateReservation = reservationOptional.get();
            updateReservation.setId(reservation.getId());
            updateReservation.setCheckIn(reservation.getCheckIn());
            updateReservation.setCheckOut(reservation.getCheckOut());
            updateReservation.setReservationDate(reservation.getReservationDate());
            updateReservation.setRoom(reservation.getRoom());
            updateReservation.setGuest(reservation.getGuest());
            return reservationRepository.save(updateReservation);
        } else {
            throw new RuntimeException("Reservation not found");
        }
    }

    public void deleteReservation(Long id) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        if (optionalReservation.isPresent()) {
            Reservation reservationDelete = optionalReservation.get();
            reservationRepository.delete(reservationDelete);
        } else {
            throw new RuntimeException("Reservation not found");
        }
    }
}


