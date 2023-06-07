package com.ua.tokarenko.hotel.dto;

import lombok.Data;
import lombok.Builder;
import com.ua.tokarenko.hotel.domain.Guest;
import com.ua.tokarenko.hotel.domain.Room;

import java.util.Date;

@Data
@Builder
public class ReservationDto {
    private Long id;
    private Date checkIn;
    private Date checkOut;
    private Date reservationDate;
    private Room room;
    private Guest guest;
}