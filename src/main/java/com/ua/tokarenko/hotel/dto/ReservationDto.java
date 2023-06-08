package com.ua.tokarenko.hotel.dto;


import lombok.Data;
import lombok.Builder;


import java.util.Date;


@Data
@Builder
public class ReservationDto {
    private Long id;
    private Date checkIn;
    private Date checkOut;
    private Date reservationDate;
    private String room;
    private String guest;
}