package controller;

/**
 *
 * @author Anisa
 */

import config.Koneksi;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SimpanSewa")
public class SimpanSewa extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        try {

            Connection conn = new Koneksi().getConnection();

            String sql =
                "INSERT INTO penyewaan VALUES (?,?,?,?,?,?)";

            PreparedStatement ps =
                conn.prepareStatement(sql);

            ps.setString(1, request.getParameter("id_sewa"));
            ps.setString(2, request.getParameter("tanggal_sewa"));
            ps.setString(3, request.getParameter("id_customer"));
            ps.setString(4, request.getParameter("id_mobil"));

            ps.setInt(5,
                Integer.parseInt(request.getParameter("lama_sewa")));

            ps.setDouble(6,
                Double.parseDouble(request.getParameter("total_bayar")));

            ps.executeUpdate();

            response.sendRedirect("sewa.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}