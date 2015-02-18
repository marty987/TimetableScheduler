<%-- 
    Document   : contact
    Created on : 16-Feb-2015, 11:51:43
    Author     : Delaney
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="guipackage.GUI;"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styles.css" media="screen" type="text/css" />
        <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,300italic' rel='stylesheet' type='text/css'>
        <title>Timetable Scheduler</title>
    </head>
   
    <body>
        <%
          GUI loginHeader = new GUI();  
          out.print( loginHeader.loginHeader() );
        %>
            
        <div class="login-card">
            <h1>Contact Us</h1>
        </div>
        
        <%
          GUI footer = new GUI();  
          out.print( footer.footer() );
        %>        
    </body>
</html>

