package com.javaspringtask2.javaspringtask2.controller;

import com.javaspringtask2.javaspringtask2.dto.ReservationDto;
import com.javaspringtask2.javaspringtask2.dto.request.ReservationRequest;
import com.javaspringtask2.javaspringtask2.repository.ReservationRepository;
import com.javaspringtask2.javaspringtask2.service.EmailSenderService;
import com.javaspringtask2.javaspringtask2.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/reservation")
public class ReservationController {
    private final ReservationService reservationService;
    private final EmailSenderService emailSenderService;
    public ReservationController(ReservationService reservationService, EmailSenderService emailSenderService) {
        this.reservationService = reservationService;
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/reserve")
    public ResponseEntity<ReservationDto> reserve(@RequestBody ReservationRequest reservationRequest){
        return ResponseEntity.ok(reservationService.reserve(reservationRequest));
    }
    @GetMapping
    public ResponseEntity<List<ReservationDto>> getAllReservations(){
        return ResponseEntity.ok(reservationService.getAllReservartions());
    }
    @GetMapping("/{restaurantId}")
    public ResponseEntity<List<ReservationDto>> getAllReservations(@PathVariable String restaurantId){
        return ResponseEntity.ok(reservationService.getReservationByRestaurant(restaurantId));
    }

    @PostMapping("/{customerId}/{reservationId}")
    public ResponseEntity<ResponseEntity> getAllReservations(@PathVariable String customerId,@PathVariable String reservationId){
        return ResponseEntity.ok(reservationService.confirmReservation(customerId,reservationId));
    }
}
