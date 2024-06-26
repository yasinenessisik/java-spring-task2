package com.javaspringtask2.javaspringtask2.service;

import com.javaspringtask2.javaspringtask2.dto.ReservationDto;
import com.javaspringtask2.javaspringtask2.dto.converter.ReservationDtoConverter;
import com.javaspringtask2.javaspringtask2.dto.request.ReservationRequest;
import com.javaspringtask2.javaspringtask2.exception.CapacityFullException;
import com.javaspringtask2.javaspringtask2.exception.ErrorCode;
import com.javaspringtask2.javaspringtask2.exception.GenericExceptionHandler;
import com.javaspringtask2.javaspringtask2.model.Customer;
import com.javaspringtask2.javaspringtask2.model.Reservation;
import com.javaspringtask2.javaspringtask2.model.Restaurant;
import com.javaspringtask2.javaspringtask2.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    private final EmailSenderService emailSenderService;


    public ReservationService(ReservationRepository reservationRepository, RestaurantService restaurantService, CustomerService customerService, ReservationDtoConverter reservationDtoConverter, EmailSenderService emailSenderService) {
        this.reservationRepository = reservationRepository;
        this.restaurantService = restaurantService;
        this.customerService = customerService;
        this.reservationDtoConverter = reservationDtoConverter;
        this.emailSenderService = emailSenderService;
    }


    public ReservationDto reserve(ReservationRequest from) {

        Restaurant restaurant = restaurantService.findRestaurants(from.getRestaurantId());
        checkReservationDate(dateFormatter(from.getReservationDate()));
        checkCapacity(from.getReservationDate(), restaurant.getCapacity(), String.valueOf(restaurant.getRestaurantId()));


        Customer customer = new Customer();
        customer.setName(from.getName());
        customer.setSurname(from.getSurname());
        customer.setPhoneNumber(from.getPhoneNumber());
        customer.isConfirm(from.isConfirm());
        customer.isKvkk(from.isKvkk());

        Customer newCustomer = customerService.saveCustomer(customer);

        Reservation reservation = new Reservation(// reservationId
                from.getReservationDescription(), // reservationDescription
                dateFormatter(from.getReservationDate()), // rezervationDate
                from.getReservationNumberOfPeople(), // reservationNumberOfPeople
                restaurant, // restaurant
                newCustomer, // customer
                new HashSet<>()// desks
        );
        Reservation reservation1 = reservationRepository.save(reservation);
        emailSenderService.sendConfirmationEmail(from.getEmail(),"Reservation Confirm Mail","", newCustomer.getCustomerId(), reservation1.getReservationId());
        return reservationDtoConverter.conver(reservation1);
    }

    public List<ReservationDto> getAllReservartions() {
        return reservationRepository.findAll().stream().map(reservation -> reservationDtoConverter.conver(reservation)).collect(Collectors.toList());
    }

    public List<ReservationDto> getReservationByRestaurant(String id) {
        return reservationRepository.getReservationByRestaurantnId(id).stream().map(reservation -> reservationDtoConverter.conver(reservation)).collect(Collectors.toList());
    }

    private void checkReservationDate(LocalDate reservationDate) {
        if (reservationDate.isBefore(LocalDate.now())) {
            throw new GenericExceptionHandler(HttpStatus.BAD_REQUEST, ErrorCode.DATE_NOT_VALID, "Rezervasyon tarihi bugünden önce olamaz.");
        }
    }

    private void checkCapacity(String reservationDate, int restaurantCapacity, String restaurantId) {
        Integer restaurantCurrentCapacity = reservationRepository.getReservationCapacityWithDate(restaurantId, dateFormatter(reservationDate));
        if (restaurantCurrentCapacity == null) {
            return;
        }
        if (restaurantCurrentCapacity > restaurantCapacity) {
            throw new CapacityFullException("Restoranın kapasitesi dolu.");
        }
    }

    private LocalDate dateFormatter(String dateString) {
        if (dateString == null) {
            // dateString null ise varsayılan bir değer döndürebilir veya istisna fırlatabilirsiniz
            throw new IllegalArgumentException("Date string cannot be null");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateString, formatter);
    }

    public ResponseEntity<String> confirmReservation(String customerId, String reservationId) {
        int updatedRowCount = reservationRepository.confirmReservation(reservationId, customerId);
        if (updatedRowCount > 0) {
            return ResponseEntity.ok("Reservation confirmed successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reservation not found or update failed");
        }
    }
}



