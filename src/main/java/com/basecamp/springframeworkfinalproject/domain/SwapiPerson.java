package com.basecamp.springframeworkfinalproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SwapiPerson {

    private String name;

    private String[] starships;
}
