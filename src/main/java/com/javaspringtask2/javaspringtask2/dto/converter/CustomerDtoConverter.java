package com.javaspringtask2.javaspringtask2.dto.converter;

import com.javaspringtask2.javaspringtask2.dto.CustomerDto;
import com.javaspringtask2.javaspringtask2.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConverter {
    public CustomerDto convert(Customer from){
        return CustomerDto.

                builder()
                .customerId(from.getCustomerId())
                .name(from.getName())
                .surname(from.getSurname())
                .phoneNumber(from.getPhoneNumber())
                .secondPhoneNumber(from.getSecondPhoneNumber())
                .build();
    }
}
