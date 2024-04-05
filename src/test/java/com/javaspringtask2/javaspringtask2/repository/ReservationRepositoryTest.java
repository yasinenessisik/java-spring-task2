package com.javaspringtask2.javaspringtask2.repository;

import com.javaspringtask2.javaspringtask2.model.Reservation;
import com.javaspringtask2.javaspringtask2.model.Restaurant;
import com.javaspringtask2.javaspringtask2.model.RestaurantType;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@DataJpaTest
public class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;

    @BeforeEach
    public void setUp() {
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setRestaurantId(1);
        restaurant1.setCapacity(300);
        restaurantRepository.save(restaurant1);


        Reservation reservation1 = new Reservation();
        reservation1.setReservationId("rezervasyon1");
        reservation1.setReservationNumberOfPeople(5);
        reservation1.setRezervationDate(LocalDate.parse("2024-04-05"));// restoranId "1" olan restoranı al
        reservation1.setRestaurant(restaurant1);
        reservationRepository.save(reservation1);

        Reservation reservation2 = new Reservation();
        reservation2.setReservationId("rezervasyon2");
        reservation2.setReservationNumberOfPeople(10);
        reservation2.setRezervationDate(LocalDate.parse("2024-04-05"));
        reservation2.setRestaurant(restaurant1);
        reservationRepository.save(reservation2);

        Reservation reservation3 = new Reservation();
        reservation3.setReservationId("rezervasyon3");
        reservation3.setReservationNumberOfPeople(5);
        reservation3.setRezervationDate(LocalDate.parse("2024-04-05"));
        reservation3.setRestaurant(restaurant1);
        reservationRepository.save(reservation3);
    }
    @Test
    public void testGetReservationCapacityWithDate() {

        String restaurantId = "1";
        LocalDate date = LocalDate.of(2024, 4, 5); // Örnek bir tarih
        Integer capacity = reservationRepository.getReservationCapacityWithDate(restaurantId, date);
        Integer expectedCapacity = 20; // Örnek bir kapasite
        assertEquals(expectedCapacity, capacity);
    }

    @Test
    public void getReservationByRestaurantnId(){

        String restaurantId = "1";
        List<Reservation> reservations = reservationRepository.getReservationByRestaurantnId(restaurantId);
        Assertions.assertThat(reservations).hasSize(3);
    }


}
