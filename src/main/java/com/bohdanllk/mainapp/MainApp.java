package com.bohdanllk;

import com.bohdanllk.model.App;
import com.bohdanllk.model.AppRelease;
import com.bohdanllk.model.Os;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {








        //        SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Os.class)
//                .addAnnotatedClass(App.class)
//                .addAnnotatedClass(AppRelease.class)
//                .buildSessionFactory();
//
//        Session session = null;
//
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        List<Os> oses = session.createQuery("SELECT i FROM Os i", Os.class).getResultList();
//        for (Os os: oses
//             ) {
//            session.remove(os);
//        }
//        session.getTransaction().commit();
//
//        session.close();


    }
}
