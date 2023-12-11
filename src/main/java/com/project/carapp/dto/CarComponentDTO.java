package com.project.carapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CarComponentDTO {
    @JsonProperty("component_id")
    Long component_id;

    @JsonProperty("count")
    Long count;
}
