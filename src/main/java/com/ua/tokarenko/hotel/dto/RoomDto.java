package com.ua.tokarenko.hotel.dto;

import lombok.Data;
import lombok.Builder;

import java.util.List;

@Data
@Builder
public class RoomDto {
    private Long id;
    private Long numberRoom;
    private Long number_of_beds;
    private Long price;
    private boolean isReserved;
    private List<String> reservations;
}