package com.javaspringtask2.javaspringtask2.repository;

import com.javaspringtask2.javaspringtask2.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,String> {
}
