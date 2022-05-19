package com.bohdanllk.dao;

import com.bohdanllk.model.App;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl extends BaseDAOImpl<App> implements AppDAO {

    @Override
    public List<App> getAll() {
        Session session = getSession();
        List<App> list = session.createQuery("FROM App").list();
        return list;
    }
}
