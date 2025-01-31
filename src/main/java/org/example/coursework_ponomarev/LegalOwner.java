package org.example.coursework_ponomarev;

public class LegalOwner extends Owner {
    private String inn;

    // Конструктор
    public LegalOwner(String name, String address, String inn) {
        super(name, address);
        this.inn = inn;
    }

    // Геттеры и сеттеры
    public String getInn() { return inn; }
    public void setInn(String inn) { this.inn = inn; }
}