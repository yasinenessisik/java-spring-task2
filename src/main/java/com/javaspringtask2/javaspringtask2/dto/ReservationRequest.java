package com.javaspringtask2.javaspringtask2.dto;

import lombok.Builder;
import lombok.Data;

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
    private String reservationNumberOfPeople;

}
