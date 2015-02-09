<%-- 
    Document   : timetable.jsp
    Created on : 09-Feb-2015, 16:44:55
    Author     : Jack Desmond
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="application.Timetable;" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UCC Timetable</title>
    </head>
    <body>
        <jsp:useBean id="register" class="application.Register" scope="request" />
        <h1>Welcome <%= session.getAttribute("username") %></h1>
        <%
            Timetable timetable = new Timetable();
            out.print(timetable.printedTimetable());
        %>
    </body>
</html>