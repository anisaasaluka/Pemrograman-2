package com.unpam.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sewa {

    private String noSewa;
    private String kodeCustomer;
    private String kodeMobil;
    private String tanggalSewa;
    private int lamaSewa;
    private double totalBayar;

    public String getNoSewa() {
        return noSewa;
    }

    public void setNoSewa(String noSewa) {
        this.noSewa = noSewa;
    }

    public String getKodeCustomer() {
        return kodeCustomer;
    }

    public void setKodeCustomer(
    String kodeCustomer) {

        this.kodeCustomer =
        kodeCustomer;
    }

    public String getKodeMobil() {
        return kodeMobil;
    }

    public void setKodeMobil(
    String kodeMobil) {

        this.kodeMobil =
        kodeMobil;
    }

    public String getTanggalSewa() {
        return tanggalSewa;
    }

    public void setTanggalSewa(
    String tanggalSewa) {

        this.tanggalSewa =
        tanggalSewa;
    }

    public int getLamaSewa() {
        return lamaSewa;
    }

    public void setLamaSewa(
    int lamaSewa) {

        this.lamaSewa =
        lamaSewa;
    }

    public double getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(
    double totalBayar) {

        this.totalBayar =
        totalBayar;
    }

    public void simpan() {

        try {

            Koneksi koneksi =
            new Koneksi();

            Connection connection =
            koneksi.getConnection();

            String sql =

            "INSERT INTO tbsewa "
            + "(noSewa, kodeCustomer, "
            + "kodeMobil, tanggalSewa, "
            + "lamaSewa, totalBayar) "
            + "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement =
            connection.prepareStatement(sql);

            preparedStatement.setString(
            1, noSewa);

            preparedStatement.setString(
            2, kodeCustomer);

            preparedStatement.setString(
            3, kodeMobil);

            preparedStatement.setString(
            4, tanggalSewa);

            preparedStatement.setInt(
            5, lamaSewa);

            preparedStatement.setDouble(
            6, totalBayar);

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

            "SELECT * FROM tbsewa "
            + "ORDER BY noSewa";

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