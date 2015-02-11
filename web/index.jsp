<%-- 
    Document   : index.jsp
    Created on : Feb 8, 2015, 12:56:25 PM
    Author     : Martin Bullman 112735341
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="application.Login;"%>
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
            <h1>Welcome, Please Login</h1>
            <%
                Login login = new Login();
                boolean hasPermission = false;

                if( request.getParameter( "submit" ) == null ){
                    out.print( login.loginForm() );
                }
                else{
                    if( login.loginUser( request )) {
                        hasPermission = true;
                        session.setAttribute("hasPermission", hasPermission);
                        session.setAttribute("firstName", login.getFirstName());
                        session.setAttribute("lastName", login.getLastName());
                        response.sendRedirect( "timetable.jsp" );
                    }
                    out.print( login.loginForm() );
                    out.print( "Username or Password incorrect, try again!" );
                }
                session.setAttribute("hasPermission", hasPermission);
            %>
            <div class="login-help">
                <p><a href="register.jsp">Register Here!</a></p>
                <p><a href="add_meeting.jsp">Add Event Here!</a></p>
            </div>
        </div>
        
        <%
          GUI footer = new GUI();  
          out.print( footer.footer() );
        %>        
    </body>
</html>
