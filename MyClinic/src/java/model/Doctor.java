/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import utils.DateUtil;

/**
 *
 * @author Student
 */
@Entity
public class Doctor extends Person{
    
    @Enumerated(EnumType.STRING)
    private Specialization specialization;
    private int age;
    private BigDecimal price;
    private Date date;
    
    @OneToMany(mappedBy="doctor", fetch=FetchType.EAGER,cascade = {CascadeType.ALL})
    private List<Entry> receptionHours;

    public Doctor() {
    }
    
    
    
    public Doctor(String name, String lastname) {
        super(name, lastname);
        receptionHours = new ArrayList();
        LocalTime time = LocalTime.of(0, 0);
//        Date date = DateUtil.localTimeToDate(time);
        for(DayOfWeek day : DayOfWeek.values())
        {            
            receptionHours.add(new Entry(day,time,time));
        }
    }

    public Doctor(Specialization specialization, String name, String lastname) {
        this(name, lastname);
        this.specialization = specialization;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setReceptionHours(DayOfWeek dayOfWeek, LocalTime from, LocalTime to) {
        for(Entry entry : receptionHours)
        {
            if(dayOfWeek==entry.getDayOfWeek())
            {
//                entry.setFrom(DateUtil.localTimeToDate(from));
//                entry.setTo(DateUtil.localTimeToDate(to));
                entry.setFrom(from);
                entry.setTo(to);
            }
        }
    }

    public List<Entry> getReceptionHours() {
        return receptionHours;
    }
    
}
