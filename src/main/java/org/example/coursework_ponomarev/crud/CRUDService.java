package org.example.coursework_ponomarev.crud;

import java.util.List;

public interface CRUDService<T> {
    void create(T entity);
    T read(int index);
    void update(int index, T updatedEntity);
    void delete(int index);
    List<T> findAll();
}