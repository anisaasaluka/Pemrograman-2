package com.unpam.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Kembali {

    private String noKembali;
    private String noSewa;
    private String tanggalKembali;
    private double denda;

    public String getNoKembali() {
        return noKembali;
    }

    public void setNoKembali(String noKembali) {
        this.noKembali = noKembali;
    }

    public String getNoSewa() {
        return noSewa;
    }

    public void setNoSewa(String noSewa) {
        this.noSewa = noSewa;
    }

    public String getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(String tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    public double getDenda() {
        return denda;
    }

    public void setDenda(double denda) {
        this.denda = denda;
    }

    public void simpan() {

        try {

            Koneksi koneksi =
            new Koneksi();

            Connection connection =
            koneksi.getConnection();

            String sql =

            "INSERT INTO tbkembali "
            + "(noKembali, noSewa, "
            + "tanggalKembali, denda) "
            + "VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement =
            connection.prepareStatement(sql);

            preparedStatement.setString(
            1, noKembali);

            preparedStatement.setString(
            2, noSewa);

            preparedStatement.setString(
            3, tanggalKembali);

            preparedStatement.setDouble(
            4, denda);

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

            "SELECT * FROM tbkembali "
            + "ORDER BY noKembali";

            PreparedStatement preparedStatement =
            connection.prepareStatement(
            SQLStatemen);

            resultSet =
            preparedStatement.executeQuery();

        } catch (SQLException ex) {

            ex.printStackTrace();
        }

        return resultSet;
    }
}