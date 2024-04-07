package com.javaspringtask2.javaspringtask2.model;

import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Entity
@ToString
public class Customer {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String customerId;
    private String email;
    private String name;
    private String surname;
    private String phoneNumber;
    private String secondPhoneNumber;

    private boolean kvkk;
    private boolean confirm;
    @OneToMany(mappedBy = "customer")
    private Set<Reservation> reservations;

    public Customer(String name, String surname, String phoneNumber, String secondPhoneNumber, boolean kvkk, boolean confirm) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.secondPhoneNumber = secondPhoneNumber;
        this.kvkk = kvkk;
        this.confirm = confirm;
        this.reservations = reservations;
    }

    public Customer() {

    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSecondPhoneNumber() {
        return secondPhoneNumber;
    }

    public void setSecondPhoneNumber(String secondPhoneNumber) {
        this.secondPhoneNumber = secondPhoneNumber;
    }

    public boolean isKvkk(boolean kvkk) {
        return this.kvkk;
    }

    public void setKvkk(boolean kvkk) {
        this.kvkk = kvkk;
    }

    public boolean isConfirm(boolean confirm) {
        return this.confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}
