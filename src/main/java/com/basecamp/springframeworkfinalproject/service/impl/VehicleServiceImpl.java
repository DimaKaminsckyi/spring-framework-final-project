package com.basecamp.springframeworkfinalproject.service.impl;

import com.basecamp.springframeworkfinalproject.domain.Vehicle;
import com.basecamp.springframeworkfinalproject.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {


    @Override
    public Vehicle countFastestVehicle(List<Vehicle> vehicles) {
        return vehicles.stream().
                max(Comparator.comparing(Vehicle::getSpeed)).get();
    }

    @Override
    public Vehicle countMostExpensiveVehicle(List<Vehicle> vehicles) {
        Comparator<Vehicle> comp = Comparator.comparingInt(p -> Integer.valueOf(p.getCost()));
        return vehicles.stream().
                max(comp).get();
    }
}
