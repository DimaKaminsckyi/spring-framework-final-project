package com.basecamp.springframeworkfinalproject.domain.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SwapiPerson {

    private String name;

    private String url;

    private String[] starships;

    private String[] vehicles;

    private String kindOfMachine;

}
