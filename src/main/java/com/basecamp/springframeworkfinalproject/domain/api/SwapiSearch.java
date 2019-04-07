package com.basecamp.springframeworkfinalproject.domain.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SwapiSearch {

    private Integer count;

    private SwapiPerson[] results;


}