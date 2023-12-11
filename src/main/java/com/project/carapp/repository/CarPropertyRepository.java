package com.project.carapp.repository;

import com.project.carapp.entity.CarProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarPropertyRepository extends JpaRepository<CarProperty, Long> {
}
