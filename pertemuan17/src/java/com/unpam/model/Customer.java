package com.unpam.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {

private String kodeCustomer;
private String namaCustomer;
private String alamat;
private String telepon;
private String noKtp;

public String getKodeCustomer() {
    return kodeCustomer;
}

public void setKodeCustomer(String kodeCustomer) {
    this.kodeCustomer = kodeCustomer;
}

public String getNamaCustomer() {
    return namaCustomer;
}

public void setNamaCustomer(String namaCustomer) {
    this.namaCustomer = namaCustomer;
}

public String getAlamat() {
    return alamat;
}

public void setAlamat(String alamat) {
    this.alamat = alamat;
}

public String getTelepon() {
    return telepon;
}

public void setTelepon(String telepon) {
    this.telepon = telepon;
}

public String getNoKtp() {
    return noKtp;
}

public void setNoKtp(String noKtp) {
    this.noKtp = noKtp;
}

public void simpan() {

    try {

        Koneksi koneksi =
        new Koneksi();

        Connection connection =
        koneksi.getConnection();

        String sql =

        "INSERT INTO tbcustomer "
        + "(kodeCustomer, namaCustomer, alamat, telepon, noKtp) "
        + "VALUES (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement =
        connection.prepareStatement(sql);

        preparedStatement.setString(
        1, kodeCustomer);

        preparedStatement.setString(
        2, namaCustomer);

        preparedStatement.setString(
        3, alamat);

        preparedStatement.setString(
        4, telepon);

        preparedStatement.setString(
        5, noKtp);

        preparedStatement.executeUpdate();

    } catch (Exception ex) {

        ex.printStackTrace();
    }
}

public ResultSet getData() {

    ResultSet resultSet = null;

    try {

        Koneksi koneksi =
        new Koneksi();

        Connection connection =
        koneksi.getConnection();

        String SQLStatemen =
        "SELECT * FROM tbcustomer ORDER BY kodeCustomer";

        PreparedStatement preparedStatement =
        connection.prepareStatement(SQLStatemen);

        resultSet =
        preparedStatement.executeQuery();

    } catch (SQLException ex) {

        ex.printStackTrace();
    }

    return resultSet;
}

}