/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package org.uv.programa01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yahir
 */
public class Programa01 {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try {
            String sql = "insert into ejemplo (clave, nombre, direccion, telefono) values " 
                    + " ('01', 'Gabriel', 'av 1', '555')";
            String url = "jdbc:postgresql://127.0.0.1:5432/ejemplo";
            String pwd = "YAHIRJE02";
            String user = "postgres";
            con = DriverManager.getConnection(url, user, pwd);
            Logger.getLogger(Programa01.class.getName()).log(Level.INFO, "Se conecto a la BD");
            st = con.createStatement();
            st.execute(sql);
            Logger.getLogger(Programa01.class.getName()).log(Level.INFO, "Se guardo...");
             
        } catch (SQLException ex) {
            Logger.getLogger(Programa01.class.getName()).log(Level.SEVERE, "No se conecto", ex);
        } finally {

            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Programa01.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Programa01.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
