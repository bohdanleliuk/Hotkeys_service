package com.bohdanllk.dao;

import com.bohdanllk.model.Hotkey;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@PropertySource("classpath:application.properties")
public class HotkeyDAOImpl extends BaseDAOImpl<Hotkey> implements HotkeyDAO {

    @Value(value = "${hibernate.jdbc.batch_size}")
    Integer BATCH_SIZE;

    //todo delegate to framework
    public void addList(List<Hotkey> hotkeyList) {
        Session session = getSession();
        for (int i = 0; i < hotkeyList.size(); i++) {
            session.persist(hotkeyList.get(i));
            if (i % BATCH_SIZE == 0) {
                session.flush();
                session.clear();
            }
        }
    }
}
