package com.unpam.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User {

    private String username;
    private String password;

    public void setUsername(
    String username) {

        this.username =
        username;
    }

    public void setPassword(
    String password) {

        this.password =
        password;
    }

    public boolean login() {

        boolean ditemukan = false;

        try {

            Koneksi koneksi =
            new Koneksi();

            Connection connection =
            koneksi.getConnection();

            String sql =

            "SELECT * FROM tbuser "
            + "WHERE username=? "
            + "AND password=?";

            PreparedStatement ps =
            connection.prepareStatement(sql);

            ps.setString(
            1,
            username);

            ps.setString(
            2,
            password);

            ResultSet rs =
            ps.executeQuery();

            ditemukan =
            rs.next();

        } catch(Exception ex) {

            ex.printStackTrace();
        }

        return ditemukan;
    }
}