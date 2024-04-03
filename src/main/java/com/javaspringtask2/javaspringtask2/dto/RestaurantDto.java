package com.javaspringtask2.javaspringtask2.dto;

import com.javaspringtask2.javaspringtask2.model.Reservation;
import com.javaspringtask2.javaspringtask2.model.RestaurantType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {

    private int restaurantId;

    private String city;
    private String state;
    private String altitude;
    private String longitude;
    private RestaurantType restaurantType;
}
