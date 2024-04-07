package com.javaspringtask2.javaspringtask2.repository;

import com.javaspringtask2.javaspringtask2.model.Reservation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation,String> {
    @Query("SELECT r FROM Reservation r WHERE r.restaurant.restaurantId = :id")
    public List<Reservation> getReservationByRestaurantnId(@Param("id") String id);

    @Query("SELECT SUM(r.reservationNumberOfPeople) from Reservation r where r.restaurant.restaurantId =:id and r.rezervationDate =:date")
    public Integer getReservationCapacityWithDate(@Param("id") String id, LocalDate date);

    @Modifying
    @Query("UPDATE Reservation r SET r.confirmed = true WHERE r.reservationId = :reservationId AND r.customer.customerId = :customerId")
    @Transactional
    int confirmReservation(@Param("reservationId") String reservationId, @Param("customerId") String customerId);

}
