/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import model.Doctor;
import model.Entry;
import model.Patient;
import model.Person;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author Student
 */
public class DBUtil {

    private static void createDB() {
        AnnotationConfiguration config = new AnnotationConfiguration();
        config.addAnnotatedClass(Person.class);
        config.addAnnotatedClass(Doctor.class);
        config.addAnnotatedClass(Patient.class);
        config.addAnnotatedClass(Entry.class);
//        config.addAnnotatedClass(Specialization.class);
//        config.addAnnotatedClass(Visit.class);
        config.configure("hibernate.cfg.xml");
        new SchemaExport(config).create(true, true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        createDB();
        
    }

}
