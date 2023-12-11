package com.project.carapp.mapper;

import com.project.carapp.dto.CarBodyDTO;
import com.project.carapp.dto.CarWheelDTO;
import com.project.carapp.entity.Component;
import com.project.carapp.entity.ComponentProperty;

import java.util.List;


public class ComponentMapper {
    public CarWheelDTO toCarWheelDto(Component component, Long componentBalance) {
        CarWheelDTO carWheelDTO = new CarWheelDTO();
        carWheelDTO.setId(component.getId());
        carWheelDTO.setCount(componentBalance);

        List<ComponentProperty> componentProperties = component.getComponentProperties();

        for (ComponentProperty prop : componentProperties) {

            if (prop.getType().equals("car_wheel_size")) {

                carWheelDTO.setSize(prop.getValue());
            }
        }
        return carWheelDTO;
    }

    public CarBodyDTO toCarBodyDto(Component component, Long componentBalance) {
        CarBodyDTO carBodyDTO = new CarBodyDTO();
        carBodyDTO.setId(component.getId());
        carBodyDTO.setCount(componentBalance);

        List<ComponentProperty> componentProperties = component.getComponentProperties();

        for (ComponentProperty prop : componentProperties) {

            if (prop.getType().equals("car_body_type")) {

                carBodyDTO.setType(prop.getValue());
            }
        }

        return carBodyDTO;
    }
}
