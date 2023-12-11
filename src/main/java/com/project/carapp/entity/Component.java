package com.project.carapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "component")
public class Component {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "component")
    private List<ComponentProperty> componentProperties;

    @OneToOne(mappedBy = "component")
    private ComponentBalance componentBalance;
}
