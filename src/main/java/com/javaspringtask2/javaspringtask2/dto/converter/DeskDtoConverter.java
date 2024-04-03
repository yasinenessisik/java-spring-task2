package com.javaspringtask2.javaspringtask2.dto.converter;

import com.javaspringtask2.javaspringtask2.dto.RestaurantDto;

public class DeskDtoConverter {

    public DeskDtoConverter convert(Desk from){
        return RestaurantDto.builder()
                .restaurantId(from.getRestaurantId())
                .city(from.getCity())
                .state(from.getState())
                .altitude(from.getAltitude())
                .longitude(from.getLongitude())
                .restaurantType(from.getRestaurantType())
                .reservations()
                .build();
    }
}
