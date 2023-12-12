package com.project.carapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "car_property")
public class CarProperty implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="car_id", referencedColumnName = "id")
    private Car car;

    @Column(name = "type")
    private String type;

    @Column(name = "value")
    private String value;
}

