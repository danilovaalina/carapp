package com.project.carapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="component_property")
@RequiredArgsConstructor
public class ComponentProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "component_id")
    private Component component;

    @Column(name = "type")
    private String type;

    @Column(name = "value")
    private String value;
}
