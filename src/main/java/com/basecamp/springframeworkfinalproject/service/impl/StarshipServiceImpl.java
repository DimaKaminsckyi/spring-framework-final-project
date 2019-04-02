package com.basecamp.springframeworkfinalproject.service.impl;

import com.basecamp.springframeworkfinalproject.domain.Starship;
import com.basecamp.springframeworkfinalproject.repository.StarshipRepository;
import com.basecamp.springframeworkfinalproject.service.StarshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StarshipServiceImpl implements StarshipService {

    private StarshipRepository starshipRepository;

    @Override
    public Starship countFastestStarship(List<Starship> starships) {
        return starships.stream().
        max(Comparator.comparing(Starship::getSpeed)).get();
    }

    @Override
    public Starship countMostExpensiveStarship(List<Starship> starships) {
        Comparator<Starship> comp = Comparator.comparingInt(p ->  Integer.valueOf(p.getCost()));
        return starships.stream().
                max(comp).get();
    }

    @Override
    public Starship findById(int id) {
        return starshipRepository.findById(id).get();
    }

    @Override
    public List<Starship> findAll() {
        List<Starship> starships = (List<Starship>) starshipRepository.findAll();
        return starships;
    }
}
