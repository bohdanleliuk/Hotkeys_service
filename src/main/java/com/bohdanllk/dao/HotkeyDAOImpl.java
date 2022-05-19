package com.bohdanllk.dao;

import com.bohdanllk.model.App;
import com.bohdanllk.model.Hotkey;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;


@Repository
@PropertySource("classpath:application.properties")
public class HotkeyDAOImpl extends BaseDAOImpl<Hotkey> implements HotkeyDAO {


    @Override
    public List<Hotkey> getAll() {
        Session session = getSession();
        List<Hotkey> list = session.createQuery("FROM Hotkey").list();
        return list;
    }

    public void addList(List<Hotkey> hotkeyList) {
        Session session = getSession();
        for (int i = 0; i < hotkeyList.size(); i++) {
            session.persist(hotkeyList.get(i));
            if (i % 10 == 0) {
                session.flush();
                session.clear();
            }
        }
    }
}
