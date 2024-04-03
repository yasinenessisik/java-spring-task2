package com.javaspringtask2.javaspringtask2.dto.converter;

import com.javaspringtask2.javaspringtask2.dto.CustomerDto;
import com.javaspringtask2.javaspringtask2.model.Customer;

import java.util.stream.Collectors;

public class CustomerDtoConverter {

    public CustomerDto conver(Customer customer){
        return CustomerDto.builder()
                .customerId(customer.getCustomerId())
                .name(customer.getName())
                .surname(customer.getSurname())
                .phoneNumber(customer.getPhoneNumber())
                .secondPhoneNumber(customer.getSecondPhoneNumber())
                .kvkk(customer.isKvkk())
                .confirm(customer.isConfirm())
                .reservations(customer.getReservations().stream().map(
                        reservation -> reservation.convert()
                ).collect(Collectors.toSet()))
                .build();
    }
}
