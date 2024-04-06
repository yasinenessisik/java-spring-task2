package com.javaspringtask2.javaspringtask2.model;

import jakarta.persistence.*;
@Entity
public class Desk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deskId;

    private int deskNumber;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "reservationId")
    private Reservation reservation;
}
