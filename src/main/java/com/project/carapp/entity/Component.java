package com.project.carapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "component")
public class Component implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "component", fetch = FetchType.EAGER)
    private List<ComponentProperty> componentProperties;

    @OneToOne(mappedBy = "component")
    private ComponentBalance componentBalance;
}
