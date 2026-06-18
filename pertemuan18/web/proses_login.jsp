<%-- 
    Document   : proses_login
    Created on : Jun 18, 2026, 10:12:58?PM
    Author     : Anisa
--%>

<%@page import="java.sql.*"%>
<%@page import="config.Koneksi"%>

<%
String username = request.getParameter("username");
String password = request.getParameter("password");

try {
    Connection conn = new Koneksi().getConnection();
    Statement st = conn.createStatement();

    ResultSet rs = st.executeQuery(
        "SELECT * FROM user WHERE username='" + username + "' AND password='" + password + "'"
    );

    if(rs.next()){
        session.setAttribute("user", username);
        response.sendRedirect("index.jsp");
    } else {
        out.println("<script>alert('Login gagal');location='login.jsp';</script>");
    }

} catch(Exception e){
    out.println(e);
}
%>