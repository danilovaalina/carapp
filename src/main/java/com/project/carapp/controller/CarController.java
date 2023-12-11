package com.project.carapp.controller;

import com.project.carapp.dto.CarComponentDTO;
import com.project.carapp.dto.CarDTO;
import com.project.carapp.entity.Car;
import com.project.carapp.mapper.CarMapper;
import com.project.carapp.service.CarService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/car")
@AllArgsConstructor
@FieldDefaults(makeFinal=true, level= AccessLevel.PRIVATE)
public class CarController {

    CarService carService;

    CarMapper carMapper;

    @PostMapping()
    public ResponseEntity<?> createCar(@RequestBody List<CarComponentDTO> componentDTOS) {
        Map<Long, Long> components = new HashMap<>();
        for (CarComponentDTO componentDTO : componentDTOS) {
            components.put(componentDTO.getComponent_id(), componentDTO.getCount());
        }
        Car car = carService.createCar(components);
        if (car == null) {
            return ResponseEntity.badRequest().body("Invalid parameter");
        } else {
            CarDTO carDTO = carMapper.toDto(car);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(car.getId())
                    .toUri();
            return ResponseEntity.created(uri)
                    .body(carDTO);
        }
    }

    @ResponseBody
    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable("id") Long id) {
        Car car = carService.getCarById(id);

        if (car == null) {
            return ResponseEntity.notFound().build();
        }

        CarDTO carDTO = carMapper.toDto(car);

        return ResponseEntity.ok(carDTO);
    }
}
