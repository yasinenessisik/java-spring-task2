package com.javaspringtask2.javaspringtask2.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequest {
    private String restaurantId;
    private String name;
    private String surname;
    private String phoneNumber;
    private String secondPhoneNumber;
    private boolean kvkk;
    private boolean confirm;
    private String reservationDescription;
    private String reservationDate;
    private int reservationNumberOfPeople;
    private String email;

}
