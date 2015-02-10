<%-- 
    Document   : timetable.jsp
    Created on : 09-Feb-2015, 16:44:55
    Author     : Jack Desmond
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="application.Timetable;" %>
<%@ page import="guipackage.GUI;"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styles.css" media="screen" type="text/css" />
        <link rel="stylesheet" href="css/timetable.css" media="screen" type="text/css" />
        <script type="text/javascript" src="js/table.js"></script>
        <title>UCC Timetable</title>
    </head>
    <body>
       
        <%
          GUI header = new GUI();  
          out.print( header.header() );
        %>  
        
        <h1 id="welcomeH">Welcome <%= session.getAttribute("username") %></h1>
        <%
            Timetable timetable = new Timetable();
            out.print(timetable.printedTimetable());
        %>
        <p><a href="logout.jsp">Logout</a></p>
    
        <%
          GUI footer = new GUI();  
          out.print( footer.footer() );
        %>  
    </body>
</html>
