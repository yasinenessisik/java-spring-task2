package com.javaspringtask2.javaspringtask2.service;

import com.javaspringtask2.javaspringtask2.model.Customer;
import com.javaspringtask2.javaspringtask2.repository.CustomerRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    protected Customer getCustomerById(String id){
        return customerRepository.findById(id).orElseThrow();
    }
    protected Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }
}
