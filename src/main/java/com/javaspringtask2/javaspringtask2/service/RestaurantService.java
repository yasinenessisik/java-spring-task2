package com.javaspringtask2.javaspringtask2.service;

import com.javaspringtask2.javaspringtask2.dto.ReservationDto;
import com.javaspringtask2.javaspringtask2.dto.RestaurantDto;
import com.javaspringtask2.javaspringtask2.dto.converter.RestaurantDtoConverter;
import com.javaspringtask2.javaspringtask2.exception.ErrorCode;
import com.javaspringtask2.javaspringtask2.exception.GenericExceptionHandler;
import com.javaspringtask2.javaspringtask2.model.Restaurant;
import com.javaspringtask2.javaspringtask2.repository.RestaurantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantDtoConverter restaurantDtoConverter;


    public RestaurantService(RestaurantRepository restaurantRepository, RestaurantDtoConverter restaurantDtoConverter) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantDtoConverter = restaurantDtoConverter;
    }

    public List<RestaurantDto> getAllRestaurants(){
        return restaurantRepository.findAll().stream().map(x -> restaurantDtoConverter.convert(x)).collect(Collectors.toList());
    }
    public Restaurant findRestaurants(String id){
        return restaurantRepository.findById(id).orElseThrow(() -> new GenericExceptionHandler(HttpStatus.NOT_FOUND, ErrorCode.RESTAURANT_NOT_FOUND,"Aradıgınız restorant bulunamadı."));
    }

    public RestaurantDto getRestaurant(String id) {
        return restaurantDtoConverter.convert(findRestaurants(id));
    }


}
