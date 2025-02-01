package org.example.coursework_ponomarev.factory;

import org.example.coursework_ponomarev.model.*;

import java.time.LocalDate;

public class VehicleFactory {
    public static Vehicle createVehicle(String category, String model, String fuelType,
                                        LocalDate techInspectionDate, Owner owner, Document document, String transmission) {
        switch (category) {
            case "Автомобиль":
                return new Car(model, category, fuelType, techInspectionDate, owner, document, transmission);
            case "Грузовик":
                return new Truck(model, category, fuelType, techInspectionDate, owner, document, transmission);
            case "Мотоцикл":
                return new Motorcycle(model, category, fuelType, techInspectionDate, owner, document, transmission);
            default:
                throw new IllegalArgumentException("Неизвестная категория транспортного средства: " + category);
        }
    }
}