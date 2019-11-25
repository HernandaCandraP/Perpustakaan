/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Abyan
 */
public class Koneksi {
    public static Connection getKoneksi(String host, String port, String username, String password, String anggota){
        String konString ="jdbc:mysql://" + host + ":" + port + "/" + anggota;
        Connection koneksi = null;
       try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(konString, username, password);
            System.out.println("koneksi berhasil");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Koneksi Database Error " + ex.getMessage());
            koneksi = null;         
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "kelas Error " + ex.getMessage());
            
        }
       return koneksi;
    }
//    public static Connection getConnection() {
//        Connection connection = null;
//        String driver = "com.mysql.jdbc.Driver";
//        String url = "jdbc:mysql://localhost:3306/perpusproyek"; //ganti dengan database mu
//        String user = "root";
//        String password = "";
//        if (connection == null) {
//            try {
//                Class.forName(driver);
//                connection = DriverManager.getConnection(url, user, password);
//            } catch (ClassNotFoundException | SQLException error) {
//               System.exit(0);
//            }
//
//        }
//        return connection;
//    }
    
}
