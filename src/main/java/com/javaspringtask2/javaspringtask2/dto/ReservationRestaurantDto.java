package com.javaspringtask2.javaspringtask2.dto;

import com.javaspringtask2.javaspringtask2.model.RestaurantType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservationRestaurantDto {
    private int restaurantId;
    private String city;
    private String state;
    private String altitude;
    private String longitude;
    private RestaurantType restaurantType;
}
