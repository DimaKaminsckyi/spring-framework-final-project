package com.basecamp.springframeworkfinalproject.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Person {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    @ApiModelProperty(notes = "The database generated character uuid")
    private UUID uuid;

    @Column(name = "person_id")
    @ApiModelProperty(notes = "Unique character id from Star Wars API")
    private int personId;

    @Column
    @ApiModelProperty(notes = "Name character from Star Wars API")
    private String name;

    @Column
    @ApiModelProperty(notes = "State request from controller {fastest/expensive}")
    private String state;

    @JsonManagedReference
    @OneToMany(mappedBy = "person" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<Machine> machines;

    public void addMachine(Machine machine) {
        this.machines.clear();
        this.machines.add(machine);
        machine.setPerson(this);
    }



}
