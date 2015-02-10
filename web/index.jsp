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
        <title>Timetable Scheduler</title>
    </head>
    

    
    <body>
        
        <%
          GUI header = new GUI();  
          out.print( header.header() );
        %>
            
        <%--
        boolean viewPermission = true;
  
        if(viewPermission )
        session.setAttribute( "VIEW", Boolean.TRUE );
        else
        session.setAttribute( "VIEW", Boolean.FALSE );
        --%>
        
      <div class="login-card">
        <h1>Welcome, Please Login</h1>
        <%
            Login login = new Login();
            
            //boolean permission = false;
            
            if( request.getParameter( "submit" ) == null ){
                out.print( login.loginForm() );
            }
            else{
                if( login.validateLogin( ) ) {
                    login.loginUser( request );
                    
                    //permission = true;
                    session.setAttribute("firstName", login.getFirstName());
                    session.setAttribute("lastName", login.getLastName());
                    
                    //session.setAttribute("permission", permission);
                    response.sendRedirect( "timetable.jsp" );
                }
                out.print( login.loginForm() );
                out.print( "Username or Password incorrect, try again!" );
            }
        %>
         <div class="login-help">

         <p><a href="register.jsp">Register Here!</a></p>
         <p><a href="add_meeting.jsp">Add Event Here!</a></p>
        </div>
      </div>
    </body>
</html>
