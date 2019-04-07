package com.basecamp.springframeworkfinalproject.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ApiModelProperty(notes = "Unique starship or vehicle id from Star Wars API")
    @Column(name = "machine_id")
    private int machineId;

    @ApiModelProperty(notes = "starship or vehicle")
    @Column(name = "kind_of_machine")
    private String kindOfMachine;

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
