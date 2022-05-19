package com.bohdanllk.dao;

import com.bohdanllk.model.App;
import com.bohdanllk.model.Os;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OsDAOImpl extends BaseDAOImpl<Os> implements OsDAO {

    @Override
    public List<Os> getAll() {
        Session session = getSession();
        List<Os> list = session.createQuery("FROM Os").list();
        return list;
    }
}
