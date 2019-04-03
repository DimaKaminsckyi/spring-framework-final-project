package com.basecamp.springframeworkfinalproject.repository;

import com.basecamp.springframeworkfinalproject.domain.Machine;
import org.springframework.data.repository.CrudRepository;

public interface MachineRepository extends CrudRepository<Machine , Integer> {
}
