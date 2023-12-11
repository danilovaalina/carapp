package com.project.carapp.mapper;

import com.project.carapp.dto.CarDTO;
import com.project.carapp.dto.CarPropertyDTO;
import com.project.carapp.entity.Car;
import com.project.carapp.entity.CarProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CarMapper {
    public CarDTO toDto(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setId(car.getId());

        List<CarProperty> carProperties = car.getCarProperties();
        List<CarPropertyDTO> carPropertyDTOS = new ArrayList<>();

        for (CarProperty carProperty : carProperties) {
            CarPropertyDTO carPropertyDTO = new CarPropertyDTO();

            carPropertyDTO.setCarId(car.getId());
            carPropertyDTO.setType(carProperty.getType());
            carPropertyDTO.setValue(carProperty.getValue());

            carPropertyDTOS.add(carPropertyDTO);
        }

        carDTO.setCarPropertyDTO(carPropertyDTOS);

        return carDTO;
    }
}
