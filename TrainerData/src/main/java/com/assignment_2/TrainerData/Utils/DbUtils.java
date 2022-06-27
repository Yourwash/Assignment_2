/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment_2.TrainerData.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dante_Fiero
 */
public class DbUtils {   

        final static String url = "jdbc:mysql://localhost:3306/george_c._azakas_individual_partb";
        final static String username = "root"; // root
        final static String password = "M@k@r0n!4Me7ur!"; //

        public static Connection getConnection() {

            Connection con = null;
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                Logger.getLogger(DbUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
            return con;
        }
    }
