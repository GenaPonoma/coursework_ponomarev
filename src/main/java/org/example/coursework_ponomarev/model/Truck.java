package org.example.coursework_ponomarev.model;

import java.time.LocalDate;

public class Truck extends Vehicle {
    private String transmission;
    public Truck(String model, String category, String fuelType, LocalDate techInspectionDate, Owner owner, Document document, String transmission) {
        super(model, category, fuelType, techInspectionDate, owner, document);
        this.transmission = transmission;
    }

    // Геттеры и сеттеры для новых полей

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
}