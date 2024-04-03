package com.javaspringtask2.javaspringtask2.dto.request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ReservationRequest {
    private String restaurantId;
    private String name;
    private String surname;
    private String phoneNumber;
    private String secondPhoneNumber;
    private boolean kvkk;
    private boolean confirm;
    private String reservationDescription;
    private String rezervationDate;
    private int reservationNumberOfPeople;

}
