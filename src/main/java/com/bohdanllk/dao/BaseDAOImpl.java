package com.bohdanllk.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.UUID;

public abstract class BaseDAOImpl<T> implements BaseDAO<T> {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Class<T> genericClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void add(T t) {
        Session session = getSession();
        session.save(t);
    }

    @Override
    public T get(UUID id) {
        Session session = getSession();
        T t = session.get(genericClass(), id);
        return t;
    }

    @Override
    public abstract List<T> getAll();

    @Override
    public T update(T t) {
        Session session = getSession();
        session.update(t);
        return t;
    }

    @Override
    public void delete(UUID id) {
        Session session = getSession();
        if (id != null) {
            session.remove(get(id));
        }
    }
}
