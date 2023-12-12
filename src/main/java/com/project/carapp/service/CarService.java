package com.project.carapp.service;

import com.project.carapp.entity.Car;
import com.project.carapp.entity.CarProperty;
import com.project.carapp.entity.ComponentProperty;
import com.project.carapp.repository.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
@CacheConfig(cacheNames = "cars")
@FieldDefaults(makeFinal=true, level= AccessLevel.PRIVATE)
public class CarService {
    CarRepository carRepository;
    CarPropertyRepository carPropertyRepository;
    ComponentPropertyRepository componentPropertyRepository;
    ComponentRepository componentRepository;
    ComponentBalanceRepository componentBalanceRepository;

    TransactionTemplate transactionTemplate;

    //TODO: Batch update for component balance
    @Cacheable(key = "#id", unless = "#result == null")
    public Car getCarById(Long id) {
       return carRepository.getCarById(id);
    }

    @CachePut()
    public Car createCar(Map<Long, Long> components) {
        Car car = new Car();
        List<CarProperty> carProperties = new ArrayList<>();
        car.setCarProperties(carProperties);

        List<Map<String, Long>> results = transactionTemplate.execute(status ->
                componentBalanceRepository.findComponentBalancesByComponentId(components.keySet()));


        Map<Long, Long> componentBalances = new HashMap<>();

        if (results != null) {
            for (Map<String, Long> result : results) {
                componentBalances.put(result.get("componentId"), result.get("count"));
            }
        } else {
            return null;
        }

        for (Long componentId : components.keySet()) {
            if (!componentBalances.containsKey(componentId)) return null;

            String type = componentRepository.findComponentById(componentId).getType();

            Long count = components.get(componentId);

            Long currentCount = componentBalances.get(componentId);

            if (type.equals("car_wheel") && count < 2) {
                 return null;
            }
            if (type.equals("car_body") && count < 1) {
                return null;
            }
            if (currentCount < count) {
                return null;
            }
            componentBalanceRepository.updateCountByComponentId(componentId, currentCount - count);

            List<ComponentProperty> componentProperties = componentPropertyRepository
                    .getComponentPropertiesById(componentId);
            for (ComponentProperty prop : componentProperties) {

                CarProperty carProperty = new CarProperty();

                carProperty.setValue(prop.getValue());
                carProperty.setType(prop.getType());

                car.addToProperties(carProperty);
            }
        }
        carPropertyRepository.saveAll(car.getCarProperties());
        carRepository.save(car);
        return car;
    }
}
