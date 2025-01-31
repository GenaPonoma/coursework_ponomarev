package org.example.coursework_ponomarev;

import java.time.LocalDate;

public class Transport {
    private String model;
    private String category;
    private String fuelType;
    private LocalDate techInspectionDate;

    // Конструктор
    public Transport(String model, String category, String fuelType, LocalDate techInspectionDate) {
        this.model = model;
        this.category = category;
        this.fuelType = fuelType;
        this.techInspectionDate = techInspectionDate;
    }

    // Геттеры и сеттеры
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getFuelType() { return fuelType; }
    public void setFuelType(String fuelType) { this.fuelType = fuelType; }

    public LocalDate getTechInspectionDate() { return techInspectionDate; }
    public void setTechInspectionDate(LocalDate techInspectionDate) { this.techInspectionDate = techInspectionDate; }
}