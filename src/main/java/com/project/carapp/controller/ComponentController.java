package com.project.carapp.controller;

import com.project.carapp.dto.CarBodyDTO;
import com.project.carapp.dto.CarWheelDTO;
import com.project.carapp.entity.Component;
import com.project.carapp.mapper.ComponentMapper;
import com.project.carapp.service.ComponentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/component")
@FieldDefaults(makeFinal=true, level= AccessLevel.PRIVATE)
public class ComponentController {
    ComponentService componentService;
    ComponentMapper componentMapper;

    @GetMapping("/wheel")
    public ResponseEntity<List<CarWheelDTO>> getAllCarWheels() {
        List<Component> components = componentService.getComponentsByType("car_wheel");

        if (components == null) {
            return ResponseEntity.notFound().build();
        }

        List<CarWheelDTO> carWheelDTOS = new ArrayList<>();

        for (Component component : components) {
            Long componentBalance = componentService.getComponentBalance(component);

            CarWheelDTO carWheelDTO = componentMapper.toCarWheelDto(component, componentBalance);

            carWheelDTOS.add(carWheelDTO);
        }

        if (carWheelDTOS.isEmpty()) {
             return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(carWheelDTOS);
    }

    @ResponseBody
    @GetMapping("/carbody")
    public ResponseEntity<List<CarBodyDTO>> getAllCarBody() {
        List<Component> components = componentService.getComponentsByType("car_body");

        if (components == null) {
            return ResponseEntity.notFound().build();
        }

        List<CarBodyDTO> carBodyDTOS = new ArrayList<>();

        for (Component component : components) {
            Long componentBalance = componentService.getComponentBalance(component);
            CarBodyDTO carBodyDTO = componentMapper.toCarBodyDto(component, componentBalance);
            carBodyDTOS.add(carBodyDTO);
        }

        if (carBodyDTOS.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(carBodyDTOS);
    }
}
