package beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import model.UserRole;

/**
 *
 * @author Student
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    private String login, password;
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

    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
    }

}
