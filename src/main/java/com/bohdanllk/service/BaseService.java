package com.bohdanllk.service;

import java.util.List;
import java.util.UUID;

public interface BaseService<T> {

    public void add(T t);

    public T get(UUID id);

    public List<T> getAll();

    public T update(T t);

    public void delete(UUID id);



}
