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

    @JsonManagedReference
    @OneToMany(mappedBy = "person" , cascade = CascadeType.ALL)
    private List<Starship> starships;

    @JsonManagedReference
    @OneToMany(mappedBy = "person" , cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;

    public void addStarship(Starship starship) {
        this.starships.add(starship);
        starship.setPerson(this);
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
        vehicle.setPerson(this);
    }

    public void clearLists(){
        this.vehicles.clear();
        this.starships.clear();
    }

}
