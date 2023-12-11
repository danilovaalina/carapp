package com.project.carapp.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CarBodyDTO {
    @JsonProperty("car_body_id")
    Long id;
    @JsonProperty("car_body_type")
    String type;
    @JsonProperty("count")
    Long count;
}
