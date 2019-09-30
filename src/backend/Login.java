/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;
import javax.swing.JOptionPane;
import java.sql.*;
/**
 *
 * @author Abyan
 */
public class Login {
    public static void main(String[] args){
        JOptionPane.showMessageDialog
            (null,"Welcome to the library");
            new Form.FormLogin().setVisible(true);
    }
}
