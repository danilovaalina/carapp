package com.project.carapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CarPropertyDTO {
    @JsonProperty("car_id")
    Long carId;

    @JsonProperty("type")
    String type;

    @JsonProperty("value")
    String value;
}
