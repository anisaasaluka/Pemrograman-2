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
import com.unpam.model.Sewa;

@WebServlet(
name = "SewaController",
urlPatterns = {"/SewaController"}
)

public class SewaController
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

    String noSewa =
    request.getParameter(
    "noSewa");

    if ((noSewa != null)
    && (!noSewa.equals(""))) {

        try {

            Sewa sewa =
            new Sewa();

            sewa.setNoSewa(
            request.getParameter(
            "noSewa"));

            sewa.setKodeCustomer(
            request.getParameter(
            "kodeCustomer"));

            sewa.setKodeMobil(
            request.getParameter(
            "kodeMobil"));

            sewa.setTanggalSewa(
            request.getParameter(
            "tanggalSewa"));

            sewa.setLamaSewa(
            Integer.parseInt(
            request.getParameter(
            "lamaSewa")));

            sewa.setTotalBayar(
            Double.parseDouble(
            request.getParameter(
            "totalBayar")));

            sewa.simpan();

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    MainForm mainForm =
    new MainForm();

    String konten =

    "<h2>Transaksi Sewa</h2>"

    + "<form method='post'>"

    + "<table>"

    + "<tr>"
    + "<td>No Sewa</td>"
    + "<td>:</td>"
    + "<td><input type='text' name='noSewa'></td>"
    + "</tr>"

    + "<tr>"
    + "<td>Kode Customer</td>"
    + "<td>:</td>"
    + "<td><input type='text' name='kodeCustomer'></td>"
    + "</tr>"

    + "<tr>"
    + "<td>Kode Mobil</td>"
    + "<td>:</td>"
    + "<td><input type='text' name='kodeMobil'></td>"
    + "</tr>"

    + "<tr>"
    + "<td>Tanggal Sewa</td>"
    + "<td>:</td>"
    + "<td><input type='date' name='tanggalSewa'></td>"
    + "</tr>"

    + "<tr>"
    + "<td>Lama Sewa</td>"
    + "<td>:</td>"
    + "<td><input type='text' name='lamaSewa'></td>"
    + "</tr>"

    + "<tr>"
    + "<td>Total Bayar</td>"
    + "<td>:</td>"
    + "<td><input type='text' name='totalBayar'></td>"
    + "</tr>"

    + "<tr>"
    + "<td colspan='3' align='center'>"

    + "<br>"

    + "<input type='submit' value='Simpan'>"

    + "&nbsp;"

    + "<input type='reset' value='Hapus'>"

    + "</td>"
    + "</tr>"

    + "</table>"

    + "</form>";

    Sewa sewa =
    new Sewa();

    ResultSet resultSet =
    sewa.getData();

    String tabel =

    "<br><h2>Daftar Sewa</h2>"

    + "<table border='1' cellpadding='5'>"

    + "<tr>"

    + "<th>No Sewa</th>"

    + "<th>Kode Customer</th>"

    + "<th>Kode Mobil</th>"

    + "<th>Tanggal Sewa</th>"

    + "<th>Lama Sewa</th>"

    + "<th>Total Bayar</th>"

    + "</tr>";

    try {

        while (resultSet.next()) {

            tabel +=

            "<tr>"

            + "<td>"
            + resultSet.getString(
            "noSewa")
            + "</td>"

            + "<td>"
            + resultSet.getString(
            "kodeCustomer")
            + "</td>"

            + "<td>"
            + resultSet.getString(
            "kodeMobil")
            + "</td>"

            + "<td>"
            + resultSet.getString(
            "tanggalSewa")
            + "</td>"

            + "<td>"
            + resultSet.getInt(
            "lamaSewa")
            + "</td>"

            + "<td>"
            + resultSet.getDouble(
            "totalBayar")
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