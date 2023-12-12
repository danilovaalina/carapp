package com.project.carapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car")
public class Car implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "car", fetch = FetchType.EAGER)
    private List<CarProperty> carProperties;

    public void addToProperties(CarProperty carProperty) {
        carProperty.setCar(this);
        this.carProperties.add(carProperty);
    }
}
