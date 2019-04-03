package com.basecamp.springframeworkfinalproject.service;

import com.basecamp.springframeworkfinalproject.domain.Machine;

import java.util.List;

public interface MachineService {

    Machine countFastestMachine(List<Machine> machines);

    Machine countMostExpensiveMachine(List<Machine> machines);

}
