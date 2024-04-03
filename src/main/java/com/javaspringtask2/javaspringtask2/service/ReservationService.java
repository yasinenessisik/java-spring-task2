package com.javaspringtask2.javaspringtask2.service;

import com.javaspringtask2.javaspringtask2.dto.ReservationDto;
import com.javaspringtask2.javaspringtask2.dto.request.ReservationRequest;
import com.javaspringtask2.javaspringtask2.dto.converter.ReservationDtoConverter;
import com.javaspringtask2.javaspringtask2.exception.CapacityFullException;
import com.javaspringtask2.javaspringtask2.exception.ErrorCode;
import com.javaspringtask2.javaspringtask2.exception.GenericExceptionHandler;
import com.javaspringtask2.javaspringtask2.model.Customer;
import com.javaspringtask2.javaspringtask2.model.Reservation;
import com.javaspringtask2.javaspringtask2.model.Restaurant;
import com.javaspringtask2.javaspringtask2.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final RestaurantService restaurantService;
    private final CustomerService customerService;
    private final ReservationDtoConverter reservationDtoConverter;


    public ReservationService(ReservationRepository reservationRepository, RestaurantService restaurantService, CustomerService customerService, ReservationDtoConverter reservationDtoConverter) {
        this.reservationRepository = reservationRepository;
        this.restaurantService = restaurantService;
        this.customerService = customerService;
        this.reservationDtoConverter = reservationDtoConverter;
    }


    public ReservationDto reserve(ReservationRequest from) {

        Restaurant restaurant = restaurantService.findRestaurants(from.getRestaurantId());
        checkReservationDate(dateFormatter(from.getRezervationDate()));



        Customer customer = new Customer();
        customer.setName(from.getName());
        customer.setSurname(from.getSurname());
        customer.setPhoneNumber(from.getPhoneNumber());
        customer.isConfirm(from.isConfirm());
        customer.isKvkk(from.isKvkk());

        Customer newCustomer = customerService.saveCustomer(customer);

        System.out.println(customer.toString());
        System.out.println(newCustomer.toString());
        Reservation reservation = new Reservation(// reservationId
                from.getReservationDescription(), // reservationDescription
                dateFormatter(from.getRezervationDate()), // rezervationDate
                from.getReservationNumberOfPeople(), // reservationNumberOfPeople
                restaurant, // restaurant
                newCustomer, // customer
                new HashSet<>() // desks
        );

        Reservation reservation1 = reservationRepository.save(reservation);
        return reservationDtoConverter.conver(reservation1);
    }

    public List<ReservationDto> getAllReservartions() {
        return reservationRepository.findAll().stream().map(reservation -> reservationDtoConverter.conver(reservation)).collect(Collectors.toList());
    }

    public List<ReservationDto> getReservationByRestaurant(String id) {
        return reservationRepository.getReservationByReservationId(id).stream().map(reservation -> reservationDtoConverter.conver(reservation)).collect(Collectors.toList());
    }

    private void checkReservationDate(LocalDate reservationDate) {
        if (reservationDate.isBefore(LocalDate.now())) {
            throw new GenericExceptionHandler(
                    HttpStatus.BAD_REQUEST,
                    ErrorCode.DATE_NOT_VALID,
                    "Rezervasyon tarihi bugünden önce olamaz."
            );
        }
    }
    private void checkCapacity(int from){
                 throw new CapacityFullException("Restoranın kapasitesi dolu.");
        }

    private LocalDate dateFormatter(String dateString){
        return LocalDate.parse(dateString);
    }

}



