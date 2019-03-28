package com.basecamp.springframeworkfinalproject.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Starship {

    @Id
    @Column(name = "starship_id")
    private int starshipId;

    @Column
    private String name;

    @Column
    private String max_atmosphering_speed;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
