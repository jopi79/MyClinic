/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;

/**
 *
 * @author Damian
 */
@Entity
public class Patient extends Person{
    private Date birthdate;
    
    private int age;
    private BigDecimal price;
    

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Patient()
    {
        
    }
    
    public Patient(String name, String lastname) {
        super(name,lastname);
    }
    
    public Patient(String name, String lastname,Date birthdate) {
        super(name,lastname);
        this.birthdate = birthdate;
    }
     
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

   



}
