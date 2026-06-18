<%-- 
    Document   : logout
    Created on : Jun 18, 2026, 10:06:17?PM
    Author     : Anisa
--%>

<%
session.invalidate();
response.sendRedirect("login.jsp");
%>