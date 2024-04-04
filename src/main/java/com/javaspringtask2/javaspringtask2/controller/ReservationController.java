package com.javaspringtask2.javaspringtask2.controller;

import com.javaspringtask2.javaspringtask2.dto.ReservationDto;
import com.javaspringtask2.javaspringtask2.dto.request.ReservationRequest;
import com.javaspringtask2.javaspringtask2.repository.ReservationRepository;
import com.javaspringtask2.javaspringtask2.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/reservation")
public class ReservationController {
    private final ReservationService reservationService;
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/reserve")
    public ResponseEntity<ReservationDto> reserve(@RequestBody ReservationRequest reservationRequest){
        return ResponseEntity.ok(reservationService.reserve(reservationRequest));
    }
    @GetMapping
    public ResponseEntity<List<ReservationDto>> getAllReservations(){
        return ResponseEntity.ok(reservationService.getAllReservartions());
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<ReservationDto>> getAllReservations(@PathVariable String id){
        return ResponseEntity.ok(reservationService.getReservationByRestaurant(id));
    }
}
