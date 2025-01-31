package org.example.coursework_ponomarev;

import java.util.List;

public class VehicleRecord {
    private Transport transport;
    private List<Owner> owners;

    // Конструктор
    public VehicleRecord(Transport transport, List<Owner> owners) {
        this.transport = transport;
        this.owners = owners;
    }

    // Геттеры и сеттеры
    public Transport getTransport() { return transport; }
    public void setTransport(Transport transport) { this.transport = transport; }

    public List<Owner> getOwners() { return owners; }
    public void setOwners(List<Owner> owners) { this.owners = owners; }
}