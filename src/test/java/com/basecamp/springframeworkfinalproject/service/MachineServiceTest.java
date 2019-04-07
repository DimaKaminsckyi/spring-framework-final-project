package com.basecamp.springframeworkfinalproject.service;

import com.basecamp.springframeworkfinalproject.domain.Machine;
import com.basecamp.springframeworkfinalproject.service.impl.MachineServiceImpl;
import com.basecamp.springframeworkfinalproject.util.TestData;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MachineServiceTest {

    MachineServiceImpl machineService = new MachineServiceImpl();

    @Test
    public void whenCountFastestMachine_thanCorrectReturnFastestMachine(){

        List<Machine> machines = TestData.generateStarships();

        Machine actual = machineService.countFastestMachine(machines);

        assertEquals("X-wing" , actual.getName());
    }

    @Test
    public void whenCountMostExpensivetMachine_thanCorrectReturnMostExpensiveMachine(){

        List<Machine> machines = TestData.generateVehicles();

        Machine actual = machineService.countMostExpensiveMachine(machines);

        assertEquals("Imperial Speeder Bike" , actual.getName());
    }

}
