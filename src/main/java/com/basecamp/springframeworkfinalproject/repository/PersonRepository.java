package com.basecamp.springframeworkfinalproject.repository;

import com.basecamp.springframeworkfinalproject.domain.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PersonRepository extends CrudRepository<Person , UUID> {
}
