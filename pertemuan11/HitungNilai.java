package proses;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/HitungNilai")
public class HitungNilai extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        int hadir = Integer.parseInt(request.getParameter("hadir"));
        int pertemuan = Integer.parseInt(request.getParameter("pertemuan"));

        int tugas = Integer.parseInt(request.getParameter("tugas"));
        int uts = Integer.parseInt(request.getParameter("uts"));
        int uas = Integer.parseInt(request.getParameter("uas"));

        double nilaiHadir = ((double) hadir / pertemuan) * 100;

        double nilaiAkhir =
                (0.1 * nilaiHadir) +
                (0.2 * tugas) +
                (0.3 * uts) +
                (0.4 * uas);

        String grade;
        String status;

        if (nilaiAkhir >= 85) {
            grade = "A";
            status = "Lulus";
        } else if (nilaiAkhir >= 70) {
            grade = "B";
            status = "Lulus";
        } else if (nilaiAkhir >= 60) {
            grade = "C";
            status = "Lulus";
        } else if (nilaiAkhir >= 50) {
            grade = "D";
            status = "Tidak Lulus";
        } else {
            grade = "E";
            status = "Tidak Lulus";
        }

        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Menghitung Nilai</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h2>Menghitung Nilai</h2>");

            out.println("<form action='index.html' method='post'>");

            out.println("<table>");

            out.println("<tr>");
            out.println("<td>Jumlah hadir</td>");
            out.println("<td><input type='text' value='" + hadir + "'></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Jumlah pertemuan</td>");
            out.println("<td><input type='text' value='" + pertemuan + "'></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Nilai tugas</td>");
            out.println("<td><input type='text' value='" + tugas + "'></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Nilai UTS</td>");
            out.println("<td><input type='text' value='" + uts + "'></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Nilai UAS</td>");
            out.println("<td><input type='text' value='" + uas + "'></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Nilai Akhir</td>");
            out.println("<td><input type='text' value='" + (int) nilaiAkhir + "'></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Grade</td>");
            out.println("<td><input type='text' value='" + grade + "'></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Status</td>");
            out.println("<td><input type='text' value='" + status + "'></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td colspan='2'>");
            out.println("<input type='submit' value='Hitung'>");
            out.println("</td>");
            out.println("</tr>");

            out.println("</table>");

            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}