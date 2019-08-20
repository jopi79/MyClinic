/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Doctor;
import model.Entry;
import model.Patient;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Student
 */
public class PatientDB {
    
    public static List<Patient> getPatients()
    {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            Criteria criteria = session.createCriteria(Patient.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            List<Patient> list = criteria.list();
            return list;
        } finally {
            session.close();
        }
    }
    
    public static void save(Patient d)
    {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Integer id = (Integer) session.save(d);
            d.setId(id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
    /*
    public static void update(Entry entry)
    {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(entry);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }*/
}
