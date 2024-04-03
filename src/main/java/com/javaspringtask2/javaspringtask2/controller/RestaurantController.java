package com.javaspringtask2.javaspringtask2.controller;

import com.javaspringtask2.javaspringtask2.dto.RestaurantDto;
import com.javaspringtask2.javaspringtask2.service.RestaurantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/restaurant")
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<RestaurantDto> getAllRestaurant(){
        return restaurantService.getAllRestaurants();
    }
    @GetMapping("/{id}")
    public RestaurantDto getReastaurant(@PathVariable String id){
        return restaurantService.getRestaurant(id);
    }
}
