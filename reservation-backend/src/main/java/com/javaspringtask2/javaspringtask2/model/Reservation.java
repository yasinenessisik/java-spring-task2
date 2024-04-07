package com.javaspringtask2.javaspringtask2.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;



@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String reservationId;

    private String reservationDescription;
    private LocalDate rezervationDate;
    private int reservationNumberOfPeople;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToMany(mappedBy = "reservation",fetch = FetchType.LAZY)
    private Set<Desk> desks;

    private Boolean confirmed;
    public Reservation(String reservationId, String reservationDescription, LocalDate rezervationDate, int reservationNumberOfPeople, Restaurant restaurant, Customer customer, Set<Desk> desks) {
        this.reservationId = reservationId;
        this.reservationDescription = reservationDescription;
        this.rezervationDate = rezervationDate;
        this.reservationNumberOfPeople = reservationNumberOfPeople;
        this.restaurant = restaurant;
        this.customer = customer;
        this.desks = desks;
        this.confirmed = false;
    }

    public Reservation(String reservationDescription, LocalDate rezervationDate, int reservationNumberOfPeople, Restaurant restaurant, Customer customer, Set<Desk> desks) {
        this.reservationDescription = reservationDescription;
        this.rezervationDate = rezervationDate;
        this.reservationNumberOfPeople = reservationNumberOfPeople;
        this.restaurant = restaurant;
        this.customer = customer;
        this.desks = desks;
        this.confirmed = false;
    }

    public Reservation() {

    }
}
