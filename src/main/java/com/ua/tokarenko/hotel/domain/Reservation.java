package com.ua.tokarenko.hotel.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @Temporal(TemporalType.DATE)
    private Date checkIn;
    @Column
    @Temporal(TemporalType.DATE)
    private Date checkOut;
    @Column
    @Temporal(TemporalType.DATE)
    private Date reservationDate;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;

}
