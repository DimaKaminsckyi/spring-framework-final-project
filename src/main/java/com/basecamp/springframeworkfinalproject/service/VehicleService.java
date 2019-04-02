package com.basecamp.springframeworkfinalproject.service;

import com.basecamp.springframeworkfinalproject.domain.Vehicle;

import java.util.List;

public interface VehicleService {

    Vehicle countFastestVehicle(List<Vehicle> vehicles);

    Vehicle countMostExpensiveVehicle(List<Vehicle> vehicles);

}
