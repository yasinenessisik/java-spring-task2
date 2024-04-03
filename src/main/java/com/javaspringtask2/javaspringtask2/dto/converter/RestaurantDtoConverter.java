package com.javaspringtask2.javaspringtask2.dto.converter;

import com.javaspringtask2.javaspringtask2.dto.RestaurantDto;
import org.springframework.stereotype.Component;


@Component
public class RestaurantDtoConverter {

    public RestaurantDto convert(RestaurantDto from){
        return RestaurantDto.builder()
                .restaurantId(from.getRestaurantId())
                .city(from.getCity())
                .state(from.getState())
                .altitude(from.getAltitude())
                .longitude(from.getLongitude())
                .restaurantType(from.getRestaurantType())
                .reservations(from.getReservations())
                .build();
    }
}
