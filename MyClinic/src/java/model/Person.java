/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Student
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="PERSON_TYPE",discriminatorType=DiscriminatorType.STRING)
public class Person {
    private static int count = 0;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OSOBA_SEQ")
    @SequenceGenerator(name = "OSOBA_SEQ", sequenceName = "OSOBA_SEQ_W_BAZIE")
    private int id;
    private String name, lastname;
    private String login, password;

    public Person() {
    }

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

    
    
    public Person(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
        this.id = ++count;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getId() {
        return id;
    }

    
    
}
