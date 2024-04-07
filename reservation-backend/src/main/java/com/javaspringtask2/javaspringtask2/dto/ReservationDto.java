package com.javaspringtask2.javaspringtask2.dto;

import com.javaspringtask2.javaspringtask2.model.Customer;
import com.javaspringtask2.javaspringtask2.model.Desk;
import com.javaspringtask2.javaspringtask2.model.Restaurant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservationDto {
    private String reservationId;

    private String reservationDescription;
    private String rezervationDate;
    private String reservationNumberOfPeople;

    private ReservationRestaurantDto restaurant;

    private CustomerDto customer;
    private Boolean confirmed;
    private Set<DeskDto> desks;
}
