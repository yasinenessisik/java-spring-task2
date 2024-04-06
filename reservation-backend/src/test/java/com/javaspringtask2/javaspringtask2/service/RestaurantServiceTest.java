package com.javaspringtask2.javaspringtask2.service;

import com.javaspringtask2.javaspringtask2.dto.converter.RestaurantDtoConverter;
import com.javaspringtask2.javaspringtask2.repository.RestaurantRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RestaurantServiceTest {

    @Autowired
    private RestaurantRepository restaurantRepository;
    
    @Autowired
    private RestaurantDtoConverter restaurantDtoConverter;
}