package com.javaspringtask2.javaspringtask2.service;

import com.javaspringtask2.javaspringtask2.dto.ReservationDto;
import com.javaspringtask2.javaspringtask2.dto.ReservationRequest;
import com.javaspringtask2.javaspringtask2.model.Customer;
import com.javaspringtask2.javaspringtask2.model.Desk;
import com.javaspringtask2.javaspringtask2.model.Reservation;
import com.javaspringtask2.javaspringtask2.model.Restaurant;
import com.javaspringtask2.javaspringtask2.repository.CustomerRepository;
import com.javaspringtask2.javaspringtask2.repository.ReservationRepository;
import com.javaspringtask2.javaspringtask2.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;
    private final RestaurantRepository restaurantRepository;

    public ReservationService(ReservationRepository reservationRepository, CustomerRepository customerRepository, RestaurantRepository restaurantRepository) {
        this.reservationRepository = reservationRepository;
        this.customerRepository = customerRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public Customer reserve(ReservationRequest from){
        Customer customer = new Customer();
        customer.setCustomerId("1");
        customer.setName("John");
        customer.setSurname("Doe");
        customer.setPhoneNumber("123-456-7890");
        Restaurant restaurant = restaurantRepository.findById("1")
                .orElseThrow(() -> new IllegalArgumentException("Restaurant with id 1 not found"));

        // Desk oluştur
        // Reservation oluştur
        Reservation reservation = new Reservation(
                "abc123", // reservationId
                "Table for four", // reservationDescription
                "2024-04-03", // rezervationDate
                "4", // reservationNumberOfPeople
                restaurant, // restaurant
                customer, // customer
                new HashSet<>() // desks
        );

        // Oluşturulan Reservation nesnesini kullanabiliriz
        System.out.println("Reservation Id: " + reservation.getReservationId());
        System.out.println("Description: " + reservation.getReservationDescription());
        System.out.println("Date: " + reservation.getRezervationDate());
        System.out.println("Number of People: " + reservation.getReservationNumberOfPeople());
        System.out.println("Restaurant: " + reservation.getRestaurant().getRestaurantId());
        System.out.println("Customer: " + reservation.getCustomer().toString());
        System.out.println("Desks: ");

        return customer;
    }

}
