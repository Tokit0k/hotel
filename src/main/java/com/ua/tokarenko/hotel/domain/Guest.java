package com.ua.tokarenko.hotel.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String passport;
    @Column
    private Long phoneNumber;

    @OneToMany(mappedBy = "guest")
    private List<Reservation> reservations;


}
