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
public class Starship {

    @Id
    @Column(name = "starship_id")
    private int starshipId;

    @JsonProperty("name")
    @Column
    private String name;

    @JsonProperty("cost_in_credits")
    @Column
    private String cost;

    @JsonProperty("max_atmosphering_speed")
    @Column
    private Integer speed;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
