package com.project.carapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CarWheelDTO {
    @JsonProperty("car_wheel_id")
    Long id;
    @JsonProperty("car_wheel_size")
    String size;
    @JsonProperty("count")
    Long count;
}
