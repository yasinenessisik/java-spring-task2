package com.javaspringtask2.javaspringtask2.dto.converter;

import com.javaspringtask2.javaspringtask2.dto.RestaurantDto;
import com.javaspringtask2.javaspringtask2.model.Restaurant;
import org.springframework.stereotype.Component;


@Component
public class RestaurantDtoConverter {

    public RestaurantDto convert(Restaurant from){
        return RestaurantDto.builder()
                .restaurantId(from.getRestaurantId())
                .city(from.getCity())
                .state(from.getState())
                .altitude(String.valueOf(from.getAltitude()))
                .longitude(String.valueOf(from.getLongitude()))
                .restaurantType(from.getRestaurantType())
                .build();
    }
}
