<%-- 
    Document   : register.jsp
    Created on : Feb 6, 2015, 11:07:11 PM
    Author     : Martin Bullman
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="application.Register;" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Timetable Scheduler</title>
    </head>
    
    <body>
        <h1>Registration!</h1>        
        <jsp:useBean id="register" class="application.Register" scope="request" />
        <jsp:setProperty name="register" property="*" />
        
        <%
            if( request.getParameter( "submit" ) == null ) {
                out.print( register.registrationForm( ) );
            }
            else {
                if( register.validateRegForm( ) ) {
                    response.sendRedirect( "reg_success.jsp" );  
                }
                out.print( register.registrationForm( ) );
                out.print( register.errors( ) );
            }
        %>
    </body>
</html>
