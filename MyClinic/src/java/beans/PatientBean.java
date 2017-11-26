/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import model.Patient;


/**
 *
 * @author Student
 */
@Named(value = "patientBean")
@RequestScoped
public class PatientBean {

    private List<Patient> patients;

    public List<Patient> getPatients() {
        return patients;
    }

    
    
    @PostConstruct
    public void init(){
         patients = new ArrayList<Patient>();
         Date date = new Date(1995,10,31);
         
         patients.add(new Patient("Jan","Adamski",date));
         Date date2 = new Date(1975,9,12);
         patients.add(new Patient("Ela","Nowak",date2));
         Date date3 = new Date(1945,11,20);
         patients.add(new Patient("Roman","Kowalski",date3));
    }


}
