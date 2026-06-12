package com.unpam.model;

import java.sql.Connection;

public class TestKoneksi {

    public static void main(String[] args) {

        Koneksi koneksi = new Koneksi();

        Connection connection =
        koneksi.getConnection();

        if (connection != null) {

            System.out.println(
            "Koneksi Berhasil");
        } else {

            System.out.println(
            "Koneksi Gagal");

            System.out.println(
            koneksi.getPesanKesalahan());
        }
    }
}