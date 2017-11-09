/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import model.Specialization;

/**
 *
 * @author Student
 */
@Named(value = "addDoctorBean")
@RequestScoped
public class AddDoctorBean {
    private String name, lastname;
    private Specialization specialization;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Specialization getSpecialization() {
        return specialization;
    }
    
    public Specialization[] getSpecializations() {
        return Specialization.values();
    }
    
    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }
    
    public AddDoctorBean() {
    }
    
}
