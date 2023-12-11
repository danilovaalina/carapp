package com.project.carapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class CarDTO {
    @JsonProperty("car_id")
    private Long id;

    @JsonProperty("car_properties")
    private List<CarPropertyDTO> carPropertyDTO;
}
