package org.example.coursework_ponomarev.model;

public class RegistrationRecord {
    private final Vehicle vehicle;


    public RegistrationRecord(Vehicle vehicle, Owner owner) {
        this.vehicle = vehicle;

    }

    public Vehicle getVehicle() {
        return vehicle;
    }

 }