<%-- 
    Document   : reset_password.jsp
    Created on : 16-Feb-2015, 19:19:00
    Author     : mjb2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="guipackage.GUI;"%>
<%@ page import="emailsender.Email;"%>
<%@ page import="application.User;"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            GUI gui = new GUI( );
        %>
        
        <h1>Reset your password!</h1>
        
        <%
            if( request.getParameter( "submit" ) == null ) {
                    out.print( gui.resetPassForm( ) );
            }
            else {
                User user = new User(  );
                user.resetPassword( (String) request.getAttribute( "password1" ), (String) request.getAttribute( "password1" ) );
                
                out.print( "Your Password has been updated!" );
            }
            
            out.print( gui.footer( ) );
        %>
    </body>
</html>
