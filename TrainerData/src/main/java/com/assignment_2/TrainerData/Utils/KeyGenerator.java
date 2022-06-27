/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assignment_2.TrainerData.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author georg
 */
public class KeyGenerator {

//    All of these methods create a key, based on a count returned from mySQL. 
//    They check, if the key already exists in the database.
//    If it does, they raise it by one and check again.        

    public static int trainerKeyGenerator() {
        int key = 0;
        Connection con = DbUtils.getConnection();
        String sql = "select count(trainerKey) from trainers";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                sql = "select trainerKey from trainers where trainerKey = ?";
                do {
                    key = rs.getInt(1) + 4001;
                    ps = con.prepareStatement(sql);
                    ps.setInt(1, key);
                    rs = ps.executeQuery();
                    key = key +1;
                } while (rs.next());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
                con.close();
                key = key - 1;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return (key);
    }
}
