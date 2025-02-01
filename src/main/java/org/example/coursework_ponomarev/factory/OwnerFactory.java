package org.example.coursework_ponomarev.factory;

import org.example.coursework_ponomarev.model.IndividualOwner;
import org.example.coursework_ponomarev.model.LegalEntityOwner;
import org.example.coursework_ponomarev.model.Owner;

public class OwnerFactory {
    public static Owner createOwner(String categoryOwner, String name, String address) {
        switch (categoryOwner) {
            case "Физическое лицо":
                return new IndividualOwner(name, address);
            case "Юридическое лицо":
                return new LegalEntityOwner(name, address);
            default:
                throw new IllegalArgumentException("Неизвестная категория лиц: " + categoryOwner);
        }
    }
}
