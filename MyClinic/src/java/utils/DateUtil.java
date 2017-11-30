/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author Student
 */
public class DateUtil {
    
    public final static int A_YEAR=2000,A_MONTH=1,A_DAY=1;
    
    public static Date localTimeToDate(LocalTime time) {
        Instant instant = time.atDate(LocalDate.of(A_YEAR, A_MONTH, A_DAY)).
                atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        return date;
    }
    
    public static LocalTime dateToLocalTime(Date date) {
        LocalTime time = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalTime();
        return time;
    }
    
    public static void main(String[]a)
    {
//        Doctor d = new Doctor(Specialization.laryngologist,"Jan","Adamski");
//        d.setReceptionHours(DayOfWeek.FRIDAY,LocalTime.of(8, 0),LocalTime.of(12,0));
//        for(Entry entry : d.getReceptionHours())
//        {
//            System.out.println(entry.getDayOfWeek()+" "
//            +entry.getFrom()+" "+entry.getTo());
//        }
//        for(Entry entry : d.getReceptionHours())
//        {
//            System.out.println(entry.getDayOfWeek()+" "
//            +entry.getFromAsDate()+" "+entry.getToAsDate());
//        }
//        
        
    }
}
