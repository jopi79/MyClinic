/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import utils.DateUtil;

/**
 *
 * @author Student
 */
@Entity
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ReceptionHours_SEQ")
    @SequenceGenerator(name = "ReceptionHours_SEQ", sequenceName = "ReceptionHours_SEQ")
    private int id;
    private DayOfWeek dayOfWeek;
    @Column(name="reception_from")
    private LocalTime from;
    @Column(name="reception_to")
    private LocalTime to;

    @ManyToOne
    private Doctor doctor;
    
    public Entry(DayOfWeek dayOfWeek, LocalTime from, LocalTime to) {
        this.dayOfWeek = dayOfWeek;
        this.from = from;
        this.to = to;
    }

    public Entry() {
    }


    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getFrom() {
        return from;
    }

    public void setFrom(LocalTime from) {
        this.from = from;
    }

    public LocalTime getTo() {
        return to;
    }

    public void setTo(LocalTime to) {
        this.to = to;
    }

    public Date getFromAsDate()
    {
        return DateUtil.localTimeToDate(from);
    }
    
    public Date getToAsDate()
    {
        return DateUtil.localTimeToDate(to);
    }
   
    public void setFromAsDate(Date date)
    {
        from = DateUtil.dateToLocalTime(date);
    }

    public void setToAsDate(Date date)
    {
        to = DateUtil.dateToLocalTime(date);
    }
    
    public String getFromAsHour()
    {
        String f = from.format(DateTimeFormatter.ISO_LOCAL_TIME);
        return f;
    }
     public String getToAsHour()
    {
        String t = to.format(DateTimeFormatter.ISO_LOCAL_TIME);
        return t;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
     
     
}
