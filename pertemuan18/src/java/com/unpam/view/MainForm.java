package com.unpam.view;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MainForm {

    public void tampilkan(
    HttpServletRequest request,
    HttpServletResponse response,
    String konten)

    throws IOException {

        response.setContentType(
        "text/html;charset=UTF-8");

        String html =

        "<!DOCTYPE html>"

        + "<html>"

        + "<head>"

        + "<meta charset='UTF-8'>"

        + "<title>Rent Car</title>"

        + "<link rel='stylesheet' "
        + "href='style.css'>"

        + "</head>"

        + "<body>"

        + "<div class='container'>"

        + "<div class='sidebar'>"

        + "<h2>🚗 Rent Car</h2>"

        + "<a href='HomeController'>Dashboard</a>"

        + "<a href='MobilController'>Mobil</a>"

        + "<a href='CustomerController'>Customer</a>"

        + "<a href='SewaController'>Sewa</a>"

        + "<a href='KembaliController'>Pengembalian</a>"

        + "<a href='LaporanSewaController'>Laporan</a>"

        + "<a href='LogoutController'>Logout</a>"

        + "</div>"

        + "<div class='content'>"

        + "<h1>Aplikasi Rent Car</h1>"

        + "<hr>"

        + konten

        + "</div>"

        + "</div>"

        + "</body>"

        + "</html>";

        response.getWriter().println(
        html);
    }
}