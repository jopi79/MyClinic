/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ResourceBundle;

/**
 *
 * @author Student
 */
public enum Specialization {
    laryngologist,
    ophthalmologist,
    pediatrician;

    private final static ResourceBundle rb
            = ResourceBundle.getBundle("messages.specializations");

    public String toString() {
        
        switch (this) {
            case pediatrician:
                return rb.getString("pediatrician");
            case laryngologist:
                return rb.getString("laryngologist");
            case ophthalmologist:
                return rb.getString("ophthalmologist");
            default:
                return "";
        }
    }
}
