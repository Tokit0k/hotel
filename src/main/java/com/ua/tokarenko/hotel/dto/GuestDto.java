package com.ua.tokarenko.hotel.dto;

import lombok.Data;
import lombok.Builder;

import java.util.List;

@Data
@Builder
public class GuestDto {
    private Long id;
    private String name;
    private String surname;
    private String passport;
    private Long phoneNumber;
    private List<String> reservations;
}