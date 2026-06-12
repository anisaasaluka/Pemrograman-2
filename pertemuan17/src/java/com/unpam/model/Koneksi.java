package com.unpam.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {

    private Connection connection;

    private String pesanKesalahan = "";

    public Connection getConnection() {

        try {

            String driver = "com.mysql.cj.jdbc.Driver";

            String url =
            "jdbc:mysql://localhost:3306/dbrentcar";

            String user = "root";

            String password = "";

            Class.forName(driver);

            connection =
            DriverManager.getConnection(
            url,
            user,
            password);

        } catch (Exception ex) {

            pesanKesalahan =
            ex.getMessage();
        }

        return connection;
    }

    public String getPesanKesalahan() {

        return pesanKesalahan;
    }
}