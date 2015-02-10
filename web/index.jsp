<%-- 
    Document   : index.jsp
    Created on : Feb 8, 2015, 12:56:25 PM
    Author     : Martin Bullman 112735341
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="application.Login;"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Timetable Scheduler</title>
    </head>
    
    <body>
        <h1>Welcome, Please Login</h1>
        <%
            Login login = new Login();
            
            if( request.getParameter( "submit" ) == null ){
                out.print( login.loginForm() );
            }
            else{
                if( login.loginUser( request )) {
                    session.setAttribute("username", login.getUsername());
                    response.sendRedirect( "timetable.jsp" );
                }
                out.print( login.loginForm() );
                out.print( "Username or Password incorrect, try again!" );
            }
        %>
        <p><a href="register.jsp">Register Here!</a></p>
        <p><a href="add_meeting.jsp">Add Event Here!</a></p>
    </body>
</html>