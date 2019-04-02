package com.basecamp.springframeworkfinalproject.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private int vechicleId;

    @JsonProperty("name")
    @Column
    private String name;

    @JsonProperty("model")
    @Column
    private String model;

    @JsonProperty("cost_in_credits")
    @Column
    private String cost;

    @JsonProperty("max_atmosphering_speed")
    @Column
    private int speed;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
