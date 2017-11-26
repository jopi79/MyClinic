/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Damian
 */
public class Patient extends Person{
    private Date birthdate;

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Patient(String name, String lastname) {
        super(name,lastname);
    }
    
    public Patient(String name, String lastname,Date birthdate) {
        super(name,lastname);
        this.birthdate = birthdate;
    }



}
