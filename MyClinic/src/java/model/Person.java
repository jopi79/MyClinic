/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Student
 */
public class Person {
    private static int count = 0;
    private int id;
    private String name, lastname;
    private String login, password;

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
