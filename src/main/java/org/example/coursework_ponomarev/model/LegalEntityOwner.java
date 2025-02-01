package org.example.coursework_ponomarev.model;

public class LegalEntityOwner implements Owner {
    private String companyName;
    private String address;

    public LegalEntityOwner(String companyName, String address) {
        this.companyName = companyName;
        this.address = address;
    }

    @Override
    public String getName() {
        return companyName;
    }

    @Override
    public void setName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "LegalEntityOwner{" +
                "companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}