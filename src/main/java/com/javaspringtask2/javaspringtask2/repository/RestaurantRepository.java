package com.javaspringtask2.javaspringtask2.repository;

import com.javaspringtask2.javaspringtask2.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,String> {
}

