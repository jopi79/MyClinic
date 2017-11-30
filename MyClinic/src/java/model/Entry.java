/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Date;
import utils.DateUtil;

/**
 *
 * @author Student
 */
public class Entry {
    private DayOfWeek dayOfWeek;
    private LocalTime from, to;

    public Entry(DayOfWeek dayOfWeek, LocalTime from, LocalTime to) {
        this.dayOfWeek = dayOfWeek;
        this.from = from;
        this.to = to;
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
}
