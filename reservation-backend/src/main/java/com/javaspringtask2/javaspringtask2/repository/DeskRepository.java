package com.javaspringtask2.javaspringtask2.repository;

import com.javaspringtask2.javaspringtask2.model.Desk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeskRepository extends JpaRepository<Desk,String> {
}
