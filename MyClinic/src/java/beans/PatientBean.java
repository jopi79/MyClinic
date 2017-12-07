package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import model.Doctor;
import model.Patient;
import model.Specialization;

/**
 *
 * @author Student
 */
@Named(value = "patientBean")
@SessionScoped
public class PatientBean implements Serializable{

    private List<Patient> patients;

    public List<Patient> getPatients() {
        return patients;
    }
    
    private int id;
    private Patient patient;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        patient = find(id);
    }
    
    private Patient find(int id)
    {
        for(Patient d : patients)
        {
            if(id==d.getId())
                return d;
        }
        return null;
    }

    public Patient getPatient() {
        return patient;
    }
    
    public PatientBean() {
    }
    
    @PostConstruct
    public void init(){
         patients = new ArrayList<Patient>();
         patients.add(new Patient("Adam", "Mickiewicz"));
         patients.add(new Patient("Abra","Kadabra"));
         patients.add(new Patient("Adam","Małysz"));
         patients.add(new Patient("John","Snow"));
         patients.add(new Patient("Ip","Man"));
    }

    public void add(Patient d) {
        patients.add(d);
    }
}
