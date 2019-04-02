package com.basecamp.springframeworkfinalproject.service;

import com.basecamp.springframeworkfinalproject.domain.Starship;

import java.util.List;

public interface StarshipService {

    Starship countFastestStarship(List<Starship> starships);

    Starship countMostExpensiveStarship(List<Starship> starships);

    Starship findById(int id);

    List<Starship> findAll();
}
