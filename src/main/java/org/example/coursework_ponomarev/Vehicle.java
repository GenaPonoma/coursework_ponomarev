package org.example.coursework_ponomarev;

import java.time.LocalDate;

public abstract class Vehicle {
    protected String model;
    protected String category;
    protected String fuelType;
    protected LocalDate techInspectionDate;
    protected Owner owner;
    protected Document document;

    // Конструктор
    public Vehicle(String model, String category, String fuelType, LocalDate techInspectionDate, Owner owner, Document document) {
        this.model = model;
        this.category = category;
        this.fuelType = fuelType;
        this.techInspectionDate = techInspectionDate;
        this.owner = owner;
        this.document = document;
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

    public Owner getOwner() { return owner; }
    public void setOwner(Owner owner) { this.owner = owner; }

    public Document getDocument() { return document; }
    public void setDocument(Document document) { this.document = document; }

}