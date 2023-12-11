package com.project.carapp.service;

import com.project.carapp.entity.Component;
import com.project.carapp.repository.ComponentBalanceRepository;
import com.project.carapp.repository.ComponentRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal=true, level= AccessLevel.PRIVATE)
public class ComponentService {
    ComponentRepository componentRepository;
    ComponentBalanceRepository componentBalanceRepository;
    public List<Component> getComponentsByType(String type) {
       return componentRepository.getComponentsByType(type);
    }

    public Long getComponentBalance(Component component) {
       return componentBalanceRepository.findCountByComponentId(component.getId());
    }
}

