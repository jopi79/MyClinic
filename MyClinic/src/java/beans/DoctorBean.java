/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import model.Doctor;
import model.Specialization;

/**
 *
 * @author Student
 */
@Named(value = "doctorBean")
@RequestScoped
public class DoctorBean {

    private List<Doctor> doctors;

    public List<Doctor> getDoctors() {
        return doctors;
    }
    
    private int id;
    private Doctor doctor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        doctor = find(id);
    }
    
    private Doctor find(int id)
    {
        for(Doctor d : doctors)
        {
            if(id==d.getId())
                return d;
        }
        return null;
    }

    public Doctor getDoctor() {
        return doctor;
    }
    
    public DoctorBean() {
    }
    
    @PostConstruct
    public void init(){
         doctors = new ArrayList<Doctor>();
         doctors.add(new Doctor(Specialization.laryngologist,"Jan","Adamski",1));
         doctors.add(new Doctor(Specialization.ophthalmologist,"Bogdan","Bączek",2));
         doctors.add(new Doctor(Specialization.pediatrician,"Cezary","Czarkowski",3));
         doctors.add(new Doctor(Specialization.laryngologist,"Damian","Dunik",4));
         doctors.add(new Doctor(Specialization.pediatrician,"Ernest","Edamski",5));
    }
}
