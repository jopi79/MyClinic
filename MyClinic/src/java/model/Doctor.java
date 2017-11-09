/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Student
 */
public class Doctor extends Person{
    
    private Specialization specialization;
    
    public Doctor(String name, String lastname) {
        super(name, lastname);
    }

    public Doctor(Specialization specialization, String name, String lastname) {
        super(name, lastname);
        this.specialization = specialization;
    }

    public Doctor(Specialization specialization, String name, String lastname, int id ) {
        super(id, name, lastname);
        this.specialization = specialization;
    }

    
    
    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }
    
}
