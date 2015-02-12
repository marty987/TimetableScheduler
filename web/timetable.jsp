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
        <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,300italic' rel='stylesheet' type='text/css'>
        <script type="text/javascript" src="js/table.js"></script>
        <title>UCC Timetable</title>
    </head>
    <body>
       
        <%
            boolean hasPermission = (Boolean) session.getAttribute("hasPermission");
            GUI gui = new GUI();
            
            if(hasPermission) {
                String fName = (String) session.getAttribute("firstName");
                String lName = (String) session.getAttribute("lastName");
                out.print(gui.header(true, fName, lName));
                Timetable timetable = new Timetable();
                out.print(timetable.printedTimetable());
            } else {
                out.print(gui.header(false, "", ""));
                out.print(gui.sessionErrorMessage());
            }
            
            out.print( gui.footer() );
        %>  
    </body>
</html>
