package com.javaspringtask2.javaspringtask2.dto.converter;

import com.javaspringtask2.javaspringtask2.dto.ReservationDto;
import com.javaspringtask2.javaspringtask2.dto.ReservationRestaurantDto;
import com.javaspringtask2.javaspringtask2.dto.RestaurantDto;
import com.javaspringtask2.javaspringtask2.model.Reservation;
import com.javaspringtask2.javaspringtask2.model.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class ReservationRestaurantDtoConverter {
    public ReservationRestaurantDto convert(Restaurant from){
        return ReservationRestaurantDto.builder()
                .restaurantId(from.getRestaurantId())
                .city(from.getCity())
                .state(from.getState())
                .altitude(String.valueOf(from.getAltitude()))
                .longitude(String.valueOf(from.getLongitude()))
                .restaurantType(from.getRestaurantType())
                .build();
    }
}
