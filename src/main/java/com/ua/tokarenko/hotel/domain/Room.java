package com.ua.tokarenko.hotel.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long numberRoom;
    @Column
    private Long numberOfBeds;
    @Column
    private Long price;
    @Column
    private boolean isReserved;

    @OneToMany
    @JoinTable(
            name = "room_reservation",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "reservation_id")
    )
    private List<Reservation> reservations;

}
