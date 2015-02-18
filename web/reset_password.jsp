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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
         <link rel="stylesheet" href="css/styles.css" media="screen" type="text/css" />
        <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,300italic' rel='stylesheet' type='text/css' />
        <title>Reset Password</title>
    </head>
    
    <body>
        <%
            GUI gui = new GUI( );
            out.print( gui.loginHeader( ) );
        %>
        
        <div class="login-card">      
            <h1>Reset your password!</h1>

            <%
                if( request.getParameter( "submit" ) == null ) {
                        out.print( gui.resetPassForm( ) );
                }
                else {
                   User user = new User(  );
                    
                   boolean passwordsMatch = user.resetPassword( request.getParameter( "password1" ), 
                           request.getParameter( "password2" ), request.getParameter( "user_id" ) );
                   if( passwordsMatch ){
                       out.print( "<p>Your Password has been successfully updated!</p>" );
                       out.print( "<a href=\"index.jsp\">Login Here!</a>" );
                   }
                   else{
                       out.print( gui.resetPassForm( ) );
                       out.print( "Your Password did not match, Try again please!" );
                   }
                }
            %>    
        </div>
        
        <%  
            out.print( gui.footer( ) );
        %>
    </body>
</html>
