package org.example.coursework_ponomarev;

public class PhysicalOwner extends Owner {
    private String passportNumber;

    // Конструктор
    public PhysicalOwner(String name, String address, String passportNumber) {
        super(name, address);
        this.passportNumber = passportNumber;
    }

    // Геттеры и сеттеры
    public String getPassportNumber() { return passportNumber; }
    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }
}