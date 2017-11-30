/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import model.Doctor;
import model.Entry;
import model.Specialization;

/**
 *
 * @author Student
 */
@Named(value = "doctorBean")
@SessionScoped
public class DoctorBean implements Serializable{

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
    
    public List<Entry> getReceptionHours()
    {
        if(doctor==null) return null;
        return doctor.getReceptionHours();
    }
    
    public DoctorBean() {
    }
    
    @PostConstruct
    public void init(){
         doctors = new ArrayList<Doctor>();
         Doctor d = new Doctor(Specialization.laryngologist,"Jan","Adamski");
         d.setReceptionHours(DayOfWeek.FRIDAY,LocalTime.of(8, 0),LocalTime.of(12,0));
         doctors.add(d);
         Doctor d2 = new Doctor(Specialization.ophthalmologist,"Bogdan","Bączek");
         d.setReceptionHours(DayOfWeek.MONDAY,LocalTime.of(12, 0),LocalTime.of(15,0));
         doctors.add(d2);
         Doctor d3 = new Doctor(Specialization.pediatrician,"Cezary","Czarkowski");
         d.setReceptionHours(DayOfWeek.TUESDAY,LocalTime.of(8, 0),LocalTime.of(12,0));
         doctors.add(d3);
         Doctor d4 = new Doctor(Specialization.laryngologist,"Damian","Dunik");
         d.setReceptionHours(DayOfWeek.WEDNESDAY,LocalTime.of(15, 0),LocalTime.of(18,0));
         doctors.add(d4);
         Doctor d5 = new Doctor(Specialization.pediatrician,"Ernest","Edamski");
         d.setReceptionHours(DayOfWeek.THURSDAY,LocalTime.of(8, 0),LocalTime.of(12,0));
         doctors.add(d5);
    }

    public void add(Doctor d) {
        doctors.add(d);
    }
}
