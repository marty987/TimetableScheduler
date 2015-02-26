<%-- 
    Document   : logout.jsp
    Created on : 10-Feb-2015, 14:44:03
    Author     : Jack Desmond
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="guipackage.GUI;"%>
<%@ page import="application.Login;"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styles.css" media="screen" type="text/css" />
        <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,300italic' rel='stylesheet' type='text/css'>
        <title>Logout</title>
    </head>
    
    <body>
        <%
          GUI gui = new GUI( );  
          out.print( gui.loginHeader( ) );
        %>       
        
        <div class="login-card">
            <img src="images/uccLogo.jpg" alt="UCC logo">
            <h1>Logout successful</h1>
            <%
                session.invalidate();
            %>
            
            <p><a href="index.jsp">Log back in</a></p> 
            
            <%
                Login login = new Login();
                
                if( request.getParameter( "submit" ) == null ){
                    out.print( login.loginForm() );
                }
                else{
                    if( login.loginUser( request )) {
                        session.setAttribute( "Authenticated", login.getUsername( ) );
                        session.setAttribute("firstName", login.getFirstName( ) );
                        session.setAttribute("lastName", login.getLastName( ) );
                        response.sendRedirect( "timetable.jsp" );
                    }
                    out.print( login.loginForm( ) );
                    out.print( "Username or Password incorrect, try again!" );
                }
            %>
            
        </div>
        
        <%
          out.print( gui.footer( ) );
        %>        
    </body>
</html>