package com.unpam.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.unpam.model.User;

@WebServlet(
name = "LoginController",
urlPatterns = {"/LoginController"}
)

public class LoginController
extends HttpServlet {

    protected void processRequest(
    HttpServletRequest request,
    HttpServletResponse response)

    throws ServletException, IOException {

        String username =
        request.getParameter(
        "username");

        String password =
        request.getParameter(
        "password");

        if ((username != null)
        && (password != null)) {

            User user =
            new User();

            user.setUsername(
            username);

            user.setPassword(
            password);

            if (user.login()) {

                HttpSession session =
                request.getSession(true);

                session.setAttribute(
                "userName",
                username);

                response.sendRedirect(
                "HomeController");

                return;

            } else {

                response.getWriter().println(

                "<h2>Login Gagal</h2>"

                + "<a href='LoginController'>"
                + "Kembali"
                + "</a>");

                return;
            }
        }

        response.setContentType(
        "text/html;charset=UTF-8");

        response.getWriter().println(

        "<!DOCTYPE html>"

        + "<html>"

        + "<head>"

        + "<meta charset='UTF-8'>"

        + "<title>Login Rent Car</title>"

        + "<style>"

        + "body{"
        + "font-family:Arial,sans-serif;"
        + "background:#f4f6f9;"
        + "display:flex;"
        + "justify-content:center;"
        + "align-items:center;"
        + "height:100vh;"
        + "margin:0;"
        + "}"

        + ".login-box{"
        + "width:350px;"
        + "background:white;"
        + "padding:30px;"
        + "border-radius:10px;"
        + "box-shadow:0 0 10px #ccc;"
        + "}"

        + ".login-box h2{"
        + "text-align:center;"
        + "color:#0d47a1;"
        + "margin-bottom:10px;"
        + "}"

        + ".login-box p{"
        + "text-align:center;"
        + "color:#666;"
        + "margin-bottom:25px;"
        + "}"

        + "label{"
        + "font-weight:bold;"
        + "}"

        + "input[type=text],"
        + "input[type=password]{"
        + "width:100%;"
        + "padding:10px;"
        + "margin-top:5px;"
        + "margin-bottom:15px;"
        + "border:1px solid #ccc;"
        + "border-radius:5px;"
        + "box-sizing:border-box;"
        + "}"

        + "input[type=submit]{"
        + "width:100%;"
        + "padding:10px;"
        + "background:#0d47a1;"
        + "color:white;"
        + "border:none;"
        + "border-radius:5px;"
        + "cursor:pointer;"
        + "font-size:16px;"
        + "}"

        + "input[type=submit]:hover{"
        + "background:#1565c0;"
        + "}"

        + "</style>"

        + "</head>"

        + "<body>"

        + "<div class='login-box'>"

        + "<h2>🚗 RENT CAR</h2>"

        + "<p>Sistem Penyewaan Mobil</p>"

        + "<form method='post'>"

        + "<label>Username</label>"

        + "<input type='text' "
        + "name='username' required>"

        + "<label>Password</label>"

        + "<input type='password' "
        + "name='password' required>"

        + "<input type='submit' "
        + "value='LOGIN'>"

        + "</form>"

        + "</div>"

        + "</body>"

        + "</html>");
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