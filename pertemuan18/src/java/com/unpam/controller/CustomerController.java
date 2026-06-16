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
import com.unpam.model.Customer;

@WebServlet(
name = "CustomerController",
urlPatterns = {"/CustomerController"}
)

public class CustomerController
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

    String kodeCustomer =
    request.getParameter(
    "kodeCustomer");

    if ((kodeCustomer != null)
    && (!kodeCustomer.equals(""))) {

        Customer customer =
        new Customer();

        customer.setKodeCustomer(
        request.getParameter(
        "kodeCustomer"));

        customer.setNamaCustomer(
        request.getParameter(
        "namaCustomer"));

        customer.setAlamat(
        request.getParameter(
        "alamat"));

        customer.setTelepon(
        request.getParameter(
        "telepon"));

        customer.setNoKtp(
        request.getParameter(
        "noKtp"));

        customer.simpan();
    }

    MainForm mainForm =
    new MainForm();

    String konten =

    "<h2>Input Customer</h2>"

    + "<form method='post'>"

    + "<table>"

    + "<tr>"
    + "<td>Kode Customer</td>"
    + "<td>:</td>"
    + "<td>"
    + "<input type='text' name='kodeCustomer'>"
    + "</td>"
    + "</tr>"

    + "<tr>"
    + "<td>Nama Customer</td>"
    + "<td>:</td>"
    + "<td>"
    + "<input type='text' name='namaCustomer'>"
    + "</td>"
    + "</tr>"

    + "<tr>"
    + "<td>Alamat</td>"
    + "<td>:</td>"
    + "<td>"
    + "<input type='text' name='alamat' size='40'>"
    + "</td>"
    + "</tr>"

    + "<tr>"
    + "<td>Telepon</td>"
    + "<td>:</td>"
    + "<td>"
    + "<input type='text' name='telepon'>"
    + "</td>"
    + "</tr>"

    + "<tr>"
    + "<td>No KTP</td>"
    + "<td>:</td>"
    + "<td>"
    + "<input type='text' name='noKtp'>"
    + "</td>"
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

    Customer customer =
    new Customer();

    ResultSet resultSet =
    customer.getData();

    String tabel =

    "<br><h2>Daftar Customer</h2>"

    + "<table border='1' cellpadding='5'>"

    + "<tr>"

    + "<th>Kode Customer</th>"

    + "<th>Nama Customer</th>"

    + "<th>Alamat</th>"

    + "<th>Telepon</th>"

    + "<th>No KTP</th>"

    + "</tr>";

    try {

        while (resultSet.next()) {

            tabel +=

            "<tr>"

            + "<td>"
            + resultSet.getString("kodeCustomer")
            + "</td>"

            + "<td>"
            + resultSet.getString("namaCustomer")
            + "</td>"

            + "<td>"
            + resultSet.getString("alamat")
            + "</td>"

            + "<td>"
            + resultSet.getString("telepon")
            + "</td>"

            + "<td>"
            + resultSet.getString("noKtp")
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