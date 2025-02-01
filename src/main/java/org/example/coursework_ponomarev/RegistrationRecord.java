package org.example.coursework_ponomarev;

public class RegistrationRecord {
    private final Vehicle vehicle;
    private final Owner owner;

    public RegistrationRecord(Vehicle vehicle, Owner owner) {
        this.vehicle = vehicle;
        this.owner = owner;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Owner getOwner() {
        return owner;
    }
}