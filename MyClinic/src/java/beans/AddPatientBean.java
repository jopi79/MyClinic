/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import java.math.BigDecimal;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import model.Patient;
import model.Specialization;

/**
 *
 * @author Student
 */
@Named(value = "addPatientBean")
@RequestScoped
public class AddPatientBean {
    
    @Size(min=1,message="{name_not_empty}")
    private String name;
    @Size(min=1,message="{lastname_not_empty}")
    private String lastname;
    

    @Min(value=18,message="{age_not_negative}")
    private int age;
    
    @NotNull(message="{price_not_empty}") 
    @DecimalMin(value="0.01",message="{price_not_negative}")
    private BigDecimal price;
    
    @NotNull(message="{date_not_empty}") 
    @Past(message="{date_past}")
    private Date birthdate;
    

    
    

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
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

    
    
  
    @Inject
    private PatientBean patientBean;
    public String add()
    {
        Patient d = new Patient(name,lastname);
        d.setAge(age);
        d.setBirthdate(birthdate);
        patientBean.add(d);
        return "patients";
    }
    
    public AddPatientBean() {
    }
    
}
