<%-- 
    Document   : register.jsp
    Created on : Feb 6, 2015, 11:07:11 PM
    Author     : Martin Bullman
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="application.User;" %>
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
          GUI gui = new GUI();  
          out.print( gui.loginHeader( ) );
        %>  
        
        <div class="login-card">       
            <h1>Registration!</h1>        
            <jsp:useBean id="register" class="application.User" scope="request" />
            <jsp:setProperty name="register" property="*" />
        
            <%

                if( request.getParameter( "submit" ) == null ) {
                    out.print( register.registrationForm( ) );
                }
                else {
                    if( register.validateRegForm( ) ) {
                        session.setAttribute( "Authenticated", register.getUserId( ) );
                        session.setAttribute( "firstName", register.getFirstName( ) );
                        session.setAttribute( "lastName", register.getLastName( ) );
                        response.sendRedirect( "timetable.jsp" );  
                    }
                    out.print( register.registrationForm( ) );
                    out.print( register.printErrors( ) );
                }
            %>
        </div>

        <%
          out.print( gui.footer( ) );
        %>       
    </body>
</html>
