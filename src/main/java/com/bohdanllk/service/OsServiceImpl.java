package com.bohdanllk.service;

import com.bohdanllk.dao.AppDAOImpl;
import com.bohdanllk.dao.HotkeyDAOImpl;
import com.bohdanllk.dao.OsDAOImpl;
import com.bohdanllk.model.App;
import com.bohdanllk.model.Hotkey;
import com.bohdanllk.model.Os;
import com.bohdanllk.util.SessionUtil;
import org.hibernate.Session;

import org.hibernate.Query;
import java.util.List;

public class HotkeyService extends SessionUtil {
    public Os addOs(Os os) {
        OsDAOImpl osDAO = new OsDAOImpl();
        osDAO.add(os);
        return os;
    }

//    public App addApp(String os, String app) {
//        Os findOs = addOs(os);
//        App find = null;
//        Session session = openTransactionSession();
//        try {
//            List<App> apps = session.createQuery("from App where name = :i").setParameter("i", app).list();
//            for (App a: apps
//            ) {
//                find = a.getOs().getId() == findOs.getId() && a.getName().equals(app) ? a : null;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (find == null) {
//                AppDAOImpl appDAO = new AppDAOImpl();
//                App newApp = new App(app, findOs);
//                appDAO.add(newApp);
//                find = newApp;
//                closeTransactionSession();
//
//            }
//        }
//        return find;
//    }
//
//    public Hotkey addHotkey(String os, String app, String combination, String description) {
//        Os findOs = addOs(os);
//        App findApp = addApp(findOs.getName(), app);
//        Hotkey find = null;
//
//        Session session = openTransactionSession();
//        try {
//            List<Hotkey> hotkeys = session.createQuery("from Hotkey where combination = :i").setParameter("i", combination).list();;
//            for (Hotkey h: hotkeys
//            ) {
//                find = h.getApp().getId() == findApp.getId() && h.getCombination().equals(combination) ? h : null;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (find == null) {
//                HotkeyDAOImpl hotkeyDAO = new HotkeyDAOImpl();
//                Hotkey newHotkey = new Hotkey(combination, description, findApp);
//                hotkeyDAO.add(newHotkey);
//                find = newHotkey;
//                closeTransactionSession();
//
//            }
//        }
//        return find;
//    }
}
