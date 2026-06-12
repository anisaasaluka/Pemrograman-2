package com.unpam.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.unpam.view.MainForm;

@WebServlet(
name = "HomeController",
urlPatterns = {"/HomeController"}
)

public class HomeController
extends HttpServlet {

    @Override
    protected void doGet(
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

        String userName =

        session.getAttribute(
        "userName").toString();

        MainForm mainForm =
        new MainForm();

        String konten =

        "<div style='background:white;"
        + "padding:30px;"
        + "border-radius:10px;"
        + "box-shadow:0 2px 8px rgba(0,0,0,0.1);"
        + "max-width:700px;'>"

        + "<h2 style='color:#0d47a1;'>"
        + "👋 Selamat Datang, "
        + "</h2>"

        + "<hr>"

        + "<h3>🚗 Sistem Informasi Penyewaan Mobil</h3>"

        + "<p>"
        + "Aplikasi Rent Car digunakan untuk "
        + "mengelola seluruh proses penyewaan mobil."
        + "</p>"

        + "<ul>"

        + "<li>Data Mobil</li>"

        + "<li>Data Customer</li>"

        + "<li>Transaksi Sewa</li>"

        + "<li>Data Pengembalian</li>"

        + "<li>Laporan Penyewaan</li>"

        + "</ul>"

        + "<p>"
        + "Silakan pilih menu pada sidebar "
        + "untuk mulai mengelola data."
        + "</p>"

        + "</div>";

        mainForm.tampilkan(
        request,
        response,
        konten);
    }
}