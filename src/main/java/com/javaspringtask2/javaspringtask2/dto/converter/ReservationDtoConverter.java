package com.javaspringtask2.javaspringtask2.dto.converter;

import com.javaspringtask2.javaspringtask2.dto.ReservationDto;
import com.javaspringtask2.javaspringtask2.dto.ReservationRestaurantDto;
import com.javaspringtask2.javaspringtask2.dto.RestaurantDto;
import com.javaspringtask2.javaspringtask2.model.Reservation;
import com.javaspringtask2.javaspringtask2.model.Restaurant;

public class ReservationDtoConverter {

    private final ReservationRestaurantDtoConverter converter;

    public ReservationDtoConverter(ReservationRestaurantDtoConverter converter) {
        this.converter = converter;
    }

    public ReservationDto conver(Reservation from){
        return ReservationDto
                .builder()
                .reservationId(from.getReservationId())
                .reservationDescription(from.getReservationDescription())
                .rezervationDate(from.getRezervationDate())
                .reservationNumberOfPeople(from.getReservationNumberOfPeople())
                .restaurant(converter.convert(from.getRestaurant()))
                .build();
    }
}
