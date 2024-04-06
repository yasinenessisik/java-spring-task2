package com.javaspringtask2.javaspringtask2.service;

import com.javaspringtask2.javaspringtask2.dto.converter.ReservationDtoConverter;
import com.javaspringtask2.javaspringtask2.dto.request.ReservationRequest;
import com.javaspringtask2.javaspringtask2.exception.CapacityFullException;
import com.javaspringtask2.javaspringtask2.model.Restaurant;
import com.javaspringtask2.javaspringtask2.repository.ReservationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private RestaurantService restaurantService;

    @Mock
    private CustomerService customerService;

    @Mock
    private ReservationDtoConverter reservationDtoConverter;

    @InjectMocks
    private ReservationService reservationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testReserve_CapacityFullException() {
        // Mock request data
        ReservationRequest request = new ReservationRequest();
        request.setRestaurantId("1");
        request.setReservationDescription("Test reservation");
        request.setRezervationDate("2024-04-10");
        request.setReservationNumberOfPeople(4);
        request.setName("Enes");
        request.setSurname("Sisik");
        request.setPhoneNumber("123456789");
        request.setConfirm(true);
        request.setKvkk(true);

        // Mock restaurant
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(1);
        restaurant.setCapacity(50);


        // Mock reservationRepository to return a capacity greater than restaurant capacity
        when(restaurantService.findRestaurants(request.getRestaurantId())).thenReturn(restaurant);
        when(reservationRepository.getReservationCapacityWithDate(anyString(), any())).thenReturn(51);

        // Perform the reservation and expect an exception
        assertThrows(CapacityFullException.class, () -> reservationService.reserve(request));
    }
    private LocalDate dateFormatter(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateString, formatter);
    }

    // Add more test cases based on different scenarios and edge cases
}
