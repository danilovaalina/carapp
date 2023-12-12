package com.project.carapp.repository;

import com.project.carapp.entity.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComponentRepository extends JpaRepository<Component, Long> {
    List<Component> findComponentsByType(String type);

    Component findComponentById(Long id);
}
