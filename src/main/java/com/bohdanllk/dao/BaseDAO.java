package com.bohdanllk.dao;

import java.util.List;
import java.util.UUID;

public interface BaseDAO <T> {

    void add(T t);

    //read
    T get(UUID id);

    List<T> getAll();

    //update
    T update(T t);

    //delete
    void delete(UUID id);

}
