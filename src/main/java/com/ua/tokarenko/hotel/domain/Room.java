package com.ua.tokarenko.hotel.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long numberRoom;
    @Column
    private Long number_of_beds;
    @Column
    private Long price;
    @Column
    private boolean isReserved;

    @OneToMany(mappedBy = "room")
    private List<Reservation> reservations;

}
