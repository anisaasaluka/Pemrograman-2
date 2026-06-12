package com.unpam.controller;

import java.io.IOException;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.unpam.model.Kembali;
import com.unpam.view.MainForm;

@WebServlet(
name = "KembaliController",
urlPatterns = {"/KembaliController"}
)

public class KembaliController
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

        String noKembali =
        request.getParameter(
        "noKembali");

        if ((noKembali != null)
        && (!noKembali.equals(""))) {

            Kembali kembali =
            new Kembali();

            kembali.setNoKembali(
            request.getParameter(
            "noKembali"));

            kembali.setNoSewa(
            request.getParameter(
            "noSewa"));

            kembali.setTanggalKembali(
            request.getParameter(
            "tanggalKembali"));

            kembali.setDenda(
            Double.parseDouble(
            request.getParameter(
            "denda")));

            kembali.simpan();
        }

        MainForm mainForm =
        new MainForm();

        String konten =

        "<h2>Transaksi Pengembalian</h2>"

        + "<form method='post'>"

        + "<table>"

        + "<tr>"
        + "<td>No Kembali</td>"
        + "<td>:</td>"
        + "<td><input type='text' name='noKembali'></td>"
        + "</tr>"

        + "<tr>"
        + "<td>No Sewa</td>"
        + "<td>:</td>"
        + "<td><input type='text' name='noSewa'></td>"
        + "</tr>"

        + "<tr>"
        + "<td>Tanggal Kembali</td>"
        + "<td>:</td>"
        + "<td><input type='date' name='tanggalKembali'></td>"
        + "</tr>"

        + "<tr>"
        + "<td>Denda</td>"
        + "<td>:</td>"
        + "<td><input type='text' name='denda'></td>"
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

        Kembali kembali =
        new Kembali();

        ResultSet resultSet =
        kembali.getData();

        String tabel =

        "<br><h2>Daftar Pengembalian</h2>"

        + "<table border='1' cellpadding='5'>"

        + "<tr>"

        + "<th>No Kembali</th>"

        + "<th>No Sewa</th>"

        + "<th>Tanggal Kembali</th>"

        + "<th>Denda</th>"

        + "</tr>";

        try {

            while (resultSet.next()) {

                tabel +=

                "<tr>"

                + "<td>"
                + resultSet.getString(
                "noKembali")
                + "</td>"

                + "<td>"
                + resultSet.getString(
                "noSewa")
                + "</td>"

                + "<td>"
                + resultSet.getString(
                "tanggalKembali")
                + "</td>"

                + "<td>"
                + resultSet.getDouble(
                "denda")
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