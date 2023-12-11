package com.project.carapp.config;

import com.project.carapp.mapper.CarMapper;
import com.project.carapp.mapper.ComponentMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarAppConfig {

    @Bean
    public CarMapper carMapper() {
        return new CarMapper();
    }

    @Bean
    public ComponentMapper componentMapper() {return new ComponentMapper();}
}
