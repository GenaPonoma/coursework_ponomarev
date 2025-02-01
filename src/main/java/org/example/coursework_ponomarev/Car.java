package org.example.coursework_ponomarev;

import java.time.LocalDate;

public class Car extends Vehicle {
    public Car(String model, String category, String fuelType, LocalDate techInspectionDate, Owner owner, Document document) {
        super(model, category, fuelType, techInspectionDate, owner, document);
    }

}