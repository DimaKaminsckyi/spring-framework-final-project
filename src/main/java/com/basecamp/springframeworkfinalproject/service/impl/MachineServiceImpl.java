package com.basecamp.springframeworkfinalproject.service.impl;

import com.basecamp.springframeworkfinalproject.domain.Machine;
import com.basecamp.springframeworkfinalproject.service.MachineService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class MachineServiceImpl implements MachineService {

    @Override
    public Machine countFastestMachine(List<Machine> machines) {
        return machines.stream().
        max(Comparator.comparing(Machine::getSpeed)).get();
    }

    @Override
    public Machine countMostExpensiveMachine(List<Machine> machines) {
        Comparator<Machine> comp = Comparator.comparingInt(p ->  Integer.valueOf(p.getCost()));
        return machines.stream().
                max(comp).get();
    }

}
