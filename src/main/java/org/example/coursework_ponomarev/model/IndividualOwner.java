package org.example.coursework_ponomarev.model;

public class IndividualOwner implements Owner {
    private String name;
    private String address;

    public IndividualOwner(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }
}

