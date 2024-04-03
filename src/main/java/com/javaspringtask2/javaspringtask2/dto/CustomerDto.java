package com.javaspringtask2.javaspringtask2.dto;

import com.javaspringtask2.javaspringtask2.model.Reservation;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class CustomerDto {
    private String customerId;
    private String name;
    private String surname;
    private String phoneNumber;
    private String secondPhoneNumber;
    private boolean kvkk;
    private boolean confirm;
    private Set<ReservationDto> reservations;
}
