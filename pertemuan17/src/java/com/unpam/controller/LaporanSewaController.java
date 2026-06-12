package com.unpam.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperExportManager;

import com.unpam.model.Koneksi;

@WebServlet(
name = "LaporanSewaController",
urlPatterns = {"/LaporanSewaController"}
)

public class LaporanSewaController
extends HttpServlet {

    protected void processRequest(
    HttpServletRequest request,
    HttpServletResponse response)

    throws ServletException, IOException {

        response.setContentType(
        "text/html;charset=UTF-8");

        try {

            Koneksi koneksi =
            new Koneksi();

            Connection connection =
            koneksi.getConnection();

            String jrxmlFile =
            getServletContext().getRealPath(
            "/reports/laporanSewa.jrxml");

            JasperReport jasperReport =
            JasperCompileManager.compileReport(
            jrxmlFile);

            JasperPrint jasperPrint =
            JasperFillManager.fillReport(
            jasperReport,
            null,
            connection);

            String folderWeb =
            getServletContext().getRealPath("/");

            String htmlFile =
            folderWeb
            + File.separator
            + "laporanSewa.html";

            JasperExportManager.exportReportToHtmlFile(
            jasperPrint,
            htmlFile);

            response.sendRedirect(
            request.getContextPath()
            + "/laporanSewa.html");

        } catch (Exception ex) {

            response.getWriter().println(

            "<h2>Terjadi Kesalahan :</h2>"

            + ex);
        }
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