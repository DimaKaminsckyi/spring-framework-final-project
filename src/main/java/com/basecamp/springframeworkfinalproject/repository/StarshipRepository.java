package com.basecamp.springframeworkfinalproject.repository;

import com.basecamp.springframeworkfinalproject.domain.Starship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarshipRepository extends JpaRepository<Starship , Integer> {
}
