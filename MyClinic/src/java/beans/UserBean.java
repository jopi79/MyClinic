package beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Size;
import model.UserRole;

/**
 *
 * @author Student
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    @Size(min=1,message = "{login_not_empty}")
    private String login;
    @Size(min=1,message = "{password_not_empty}")
    private String password;
    private UserRole role;
    private boolean logged = false;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String logIn() {
        if ("jan".equals(login)) {
            role = UserRole.PATIENT;
            logged = true;
            return "/index";
        }
        if ("adam".equals(login)) {
            role = UserRole.DOCTOR;
            logged = true;
            return "/index";
        }
        if ("ala".equals(login)) {
            role = UserRole.RECEPTIONIST;
            logged = true;
            return "/reception/index";
        }
        logged = false;
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage("Logowanie nie powiodło się");
        message.setSeverity(FacesMessage.SEVERITY_ERROR);
        context.addMessage(null, message);
        return null;
    }

    public UserRole getRole() {
        return role;
    }

    public boolean isLogged() {
        return logged;
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().
                invalidateSession();
        logged = false;
        role = null;
        return "/index";
    }

    public String english() {
        FacesContext c = FacesContext.getCurrentInstance();
        c.getViewRoot().setLocale(Locale.ENGLISH);
        return null;
    }

    public String polish() {
        FacesContext c = FacesContext.getCurrentInstance();
        c.getViewRoot().setLocale(new Locale("pl"));
        return null;
    }

    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
    }

}
