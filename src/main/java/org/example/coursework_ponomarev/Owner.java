package org.example.coursework_ponomarev;

public abstract class Owner {
    protected String name;
    protected String address;

    // Конструктор
    public Owner(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Геттеры и сеттеры
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}