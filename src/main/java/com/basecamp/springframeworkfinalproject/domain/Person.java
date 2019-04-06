package com.basecamp.springframeworkfinalproject.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Person {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID uuid;

    @Column(name = "person_id")
    private int personId;

    @Column
    private String name;

    @Column
    private String state;

    @JsonManagedReference
    @OneToMany(mappedBy = "person" , cascade = CascadeType.ALL)
    private List<Machine> machines;

    public void addMachine(Machine machine) {
        this.machines.clear();
        this.machines.add(machine);
        machine.setPerson(this);
    }



}
