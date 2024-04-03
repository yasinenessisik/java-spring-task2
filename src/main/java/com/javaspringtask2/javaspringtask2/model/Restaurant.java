package com.javaspringtask2.javaspringtask2.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int restaurantId;

    private String city;
    private String state;
    private double altitude;
    private double longitude;
    @Enumerated(value = EnumType.STRING)
    private RestaurantType restaurantType;

    @OneToMany(mappedBy = "restaurant",fetch = FetchType.LAZY)
    private Set<Reservation> reservations;
}
