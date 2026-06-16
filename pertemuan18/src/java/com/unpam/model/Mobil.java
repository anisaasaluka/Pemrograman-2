package com.unpam.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mobil {

    private String kodeMobil;
    private String namaMobil;
    private String merk;
    private int tahun;
    private double tarifSewa;
    private String statusMobil;

    private String pesan;

    private final Koneksi koneksi =
    new Koneksi();

    public String getKodeMobil() {

        return kodeMobil;
    }

    public void setKodeMobil(
    String kodeMobil) {

        this.kodeMobil =
        kodeMobil;
    }

    public String getNamaMobil() {

        return namaMobil;
    }

    public void setNamaMobil(
    String namaMobil) {

        this.namaMobil =
        namaMobil;
    }

    public String getMerk() {

        return merk;
    }

    public void setMerk(
    String merk) {

        this.merk =
        merk;
    }

    public int getTahun() {

        return tahun;
    }

    public void setTahun(
    int tahun) {

        this.tahun =
        tahun;
    }

    public double getTarifSewa() {

        return tarifSewa;
    }

    public void setTarifSewa(
    double tarifSewa) {

        this.tarifSewa =
        tarifSewa;
    }

    public String getStatusMobil() {

        return statusMobil;
    }

    public void setStatusMobil(
    String statusMobil) {

        this.statusMobil =
        statusMobil;
    }

    public String getPesan() {

        return pesan;
    }

    public boolean simpan() {

        boolean adaKesalahan =
        false;

        Connection connection;

        if ((connection =
        koneksi.getConnection())
        != null) {

            try {

                String SQLStatemen =

                "INSERT INTO tbmobil "
                + "(kodeMobil,"
                + "namaMobil,"
                + "merk,"
                + "tahun,"
                + "tarifSewa,"
                + "statusMobil) "
                + "VALUES "
                + "(?,?,?,?,?,?)";

                PreparedStatement
                preparedStatement =

                connection.prepareStatement(
                SQLStatemen);

                preparedStatement.setString(
                1,
                kodeMobil);

                preparedStatement.setString(
                2,
                namaMobil);

                preparedStatement.setString(
                3,
                merk);

                preparedStatement.setInt(
                4,
                tahun);

                preparedStatement.setDouble(
                5,
                tarifSewa);

                preparedStatement.setString(
                6,
                statusMobil);

                preparedStatement.executeUpdate();

                preparedStatement.close();

                connection.close();

            } catch (SQLException ex) {

                adaKesalahan =
                true;

                pesan =

                "Gagal menyimpan data mobil\n"

                + ex.getMessage();
            }

        } else {

            adaKesalahan =
            true;

            pesan =

            koneksi.getPesanKesalahan();
        }

        return !adaKesalahan;
    }

    public ResultSet getData() {

        ResultSet resultSet =
        null;

        Connection connection;

        if ((connection =
        koneksi.getConnection())
        != null) {

            try {

                String SQLStatemen =

                "SELECT * "
                + "FROM tbmobil "
                + "ORDER BY kodeMobil";

                PreparedStatement
                preparedStatement =

                connection.prepareStatement(
                SQLStatemen);

                resultSet =

                preparedStatement.executeQuery();

            } catch (SQLException ex) {

                pesan =

                "Tidak dapat membaca "
                + "data mobil\n"

                + ex.getMessage();
            }
        }

        return resultSet;
    }
}