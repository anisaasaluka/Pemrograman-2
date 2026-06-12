package com.unpam.controller;

import java.io.IOException;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.unpam.view.MainForm;
import com.unpam.model.Mobil;

@WebServlet(
name = "MobilController",
urlPatterns = {"/MobilController"}
)

public class MobilController
extends HttpServlet {

    protected void processRequest(
    HttpServletRequest request,
    HttpServletResponse response)

    throws ServletException, IOException {

        HttpSession session =
        request.getSession(false);

        if (session == null) {

            response.sendRedirect(
            "LoginController");

            return;
        }

        String kodeMobil =
        request.getParameter(
        "kodeMobil");

        if ((kodeMobil != null)
        && (!kodeMobil.equals(""))) {

            Mobil mobil =
            new Mobil();

            mobil.setKodeMobil(
            request.getParameter(
            "kodeMobil"));

            mobil.setNamaMobil(
            request.getParameter(
            "namaMobil"));

            mobil.setMerk(
            request.getParameter(
            "merk"));

            mobil.setTahun(
            Integer.parseInt(
            request.getParameter(
            "tahun")));

            mobil.setTarifSewa(
            Double.parseDouble(
            request.getParameter(
            "tarifSewa")));

            mobil.setStatusMobil(
            request.getParameter(
            "statusMobil"));

            mobil.simpan();
        }

        MainForm mainForm =
        new MainForm();

        String konten =

        "<h2>Input Mobil</h2>"

        + "<form method='post'>"

        + "<table>"

        + "<tr>"
        + "<td>Kode Mobil</td>"
        + "<td>:</td>"
        + "<td>"
        + "<input type='text' "
        + "name='kodeMobil'>"
        + "</td>"
        + "</tr>"

        + "<tr>"
        + "<td>Nama Mobil</td>"
        + "<td>:</td>"
        + "<td>"
        + "<input type='text' "
        + "name='namaMobil'>"
        + "</td>"
        + "</tr>"

        + "<tr>"
        + "<td>Merk</td>"
        + "<td>:</td>"
        + "<td>"
        + "<input type='text' "
        + "name='merk'>"
        + "</td>"
        + "</tr>"

        + "<tr>"
        + "<td>Tahun</td>"
        + "<td>:</td>"
        + "<td>"
        + "<input type='text' "
        + "name='tahun'>"
        + "</td>"
        + "</tr>"

        + "<tr>"
        + "<td>Tarif Sewa</td>"
        + "<td>:</td>"
        + "<td>"
        + "<input type='text' "
        + "name='tarifSewa'>"
        + "</td>"
        + "</tr>"

        + "<tr>"
        + "<td>Status Mobil</td>"
        + "<td>:</td>"
        + "<td>"
        + "<input type='text' "
        + "name='statusMobil'>"
        + "</td>"
        + "</tr>"

        + "<tr>"
        + "<td colspan='3' "
        + "align='center'>"

        + "<br>"

        + "<input type='submit' "
        + "value='Simpan'>"

        + "&nbsp;"

        + "<input type='reset' "
        + "value='Hapus'>"

        + "</td>"
        + "</tr>"

        + "</table>"

        + "</form>";

        Mobil mobil =
        new Mobil();

        ResultSet resultSet =
        mobil.getData();

        String tabel =

        "<br><h2>Daftar Mobil</h2>"

        + "<table border='1' cellpadding='5'>"

        + "<tr>"

        + "<th>Kode Mobil</th>"

        + "<th>Nama Mobil</th>"

        + "<th>Merk</th>"

        + "<th>Tahun</th>"

        + "<th>Tarif Sewa</th>"

        + "<th>Status</th>"

        + "</tr>";

        try {

            while (resultSet.next()) {

                tabel +=

                "<tr>"

                + "<td>"
                + resultSet.getString(
                "kodeMobil")
                + "</td>"

                + "<td>"
                + resultSet.getString(
                "namaMobil")
                + "</td>"

                + "<td>"
                + resultSet.getString(
                "merk")
                + "</td>"

                + "<td>"
                + resultSet.getInt(
                "tahun")
                + "</td>"

                + "<td>"
                + resultSet.getDouble(
                "tarifSewa")
                + "</td>"

                + "<td>"
                + resultSet.getString(
                "statusMobil")
                + "</td>"

                + "</tr>";
            }

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        tabel += "</table>";

        konten += tabel;

        mainForm.tampilkan(
        request,
        response,
        konten);
    }

    @Override
    protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response)

    throws ServletException, IOException {

        processRequest(
        request,
        response);
    }

    @Override
    protected void doPost(
    HttpServletRequest request,
    HttpServletResponse response)

    throws ServletException, IOException {

        processRequest(
        request,
        response);
    }
}