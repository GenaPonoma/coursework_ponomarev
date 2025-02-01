package org.example.coursework_ponomarev.crud;

import org.example.coursework_ponomarev.model.RegistrationRecord;

import java.util.ArrayList;
import java.util.List;

public class RegistrationRecordService implements CRUDService<RegistrationRecord> {
    private final List<RegistrationRecord> records;

    public RegistrationRecordService() {
        this.records = new ArrayList<>();
    }

    @Override
    public void create(RegistrationRecord entity) {
        records.add(entity);
    }

    @Override
    public RegistrationRecord read(int index) {
        return records.get(index);
    }

    @Override
    public void update(int index, RegistrationRecord updatedEntity) {
        records.set(index, updatedEntity);
    }

    @Override
    public void delete(int index) {
        records.remove(index);
    }

    @Override
    public List<RegistrationRecord> findAll() {
        return new ArrayList<>(records);
    }
}