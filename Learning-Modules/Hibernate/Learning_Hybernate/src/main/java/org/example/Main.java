package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SessionFactory fac = new Configuration().configure().buildSessionFactory();
        Session session = fac.openSession();
        Students st = new Students("Alexa",69);
        session.beginTransaction();
        session.persist(st);
        session.getTransaction().commit();
        session.close();
        fac.close();
    }
}