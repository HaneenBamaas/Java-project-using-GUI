/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class SocSecException extends Exception{
   
    private String error;
    public SocSecException(String error) {
        
        super("Invalid id number, " + error);
        JOptionPane.showMessageDialog(null, "Invalid id number,"+error);
    }
}
