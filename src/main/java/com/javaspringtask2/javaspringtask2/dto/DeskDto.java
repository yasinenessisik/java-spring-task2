package com.javaspringtask2.javaspringtask2.dto;

import com.javaspringtask2.javaspringtask2.model.Reservation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeskDto {
    private int deskId;

    private int deskNumber;

    private ReservationDto reservation;
}
