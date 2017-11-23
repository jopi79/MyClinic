/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.math.BigDecimal;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import model.Doctor;
import model.Specialization;

/**
 *
 * @author Student
 */
@Named(value = "addDoctorBean")
@RequestScoped
public class AddDoctorBean {
    
    @Size(min=1,message="{name_not_empty}")
    private String name;
    @Size(min=1,message="{lastname_not_empty}")
    private String lastname;
    
    private Specialization specialization;

    @Min(value=18,message="{age_not_negative}")
    private int age;
    
    @NotNull(message="{price_not_empty}") 
    @DecimalMin(value="0.01",message="{price_not_negative}")
    private BigDecimal price;
    
    @NotNull(message="{date_not_empty}") 
    @Past(message="{date_past}")
    private Date date;

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
    @Inject
    private DoctorBean doctorBean;
    public String add()
    {
        Doctor d = new Doctor(specialization,name,lastname);
        d.setAge(age);
        d.setDate(date);
        d.setPrice(price);
        doctorBean.add(d);
        return "doctors";
    }
    
    public AddDoctorBean() {
    }
    
}
