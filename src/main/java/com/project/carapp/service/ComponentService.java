package com.project.carapp.service;

import com.project.carapp.entity.Component;
import com.project.carapp.repository.ComponentBalanceRepository;
import com.project.carapp.repository.ComponentRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal=true, level= AccessLevel.PRIVATE)
public class ComponentService {
    ComponentRepository componentRepository;
    ComponentBalanceRepository componentBalanceRepository;
    @Cacheable(cacheNames = "components", key = "#type", unless = "#result == null")
    public List<Component> getComponentsByType(String type) {
       return componentRepository.findComponentsByType(type);
    }

    @Cacheable(cacheNames = "componentBalance", key = "#component.id", unless = "#result == null")
    public Long getComponentBalance(Component component) {
       return componentBalanceRepository.findCountByComponentId(component.getId());
    }
}

