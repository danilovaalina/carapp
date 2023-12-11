package com.project.carapp.repository;

import com.project.carapp.entity.ComponentProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComponentPropertyRepository extends JpaRepository<ComponentProperty, Long> {
    List<ComponentProperty> getComponentPropertiesById(Long id);
}
