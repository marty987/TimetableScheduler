<%-- 
    Document   : forgot_password.jsp
    Created on : Feb 12, 2015, 11:41:10 PM
    Author     : Martin Bullman 112735341
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="guipackage.GUI;"%>
<%@ page import="emailsender.Email;"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" href="css/styles.css" media="screen" type="text/css" />
        <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,300italic' rel='stylesheet' type='text/css' />        
        <title>Forgot Password!</title>
    </head>
    
    <body>
        <%
            GUI gui = new GUI( );  
            out.print( gui.loginHeader( ) );
        %>  
        
        <div class="login-card">  
            <h1>You forgot your password again!</h1>
            <p>Please enter your user ID, and we'll send you a link to reset your current password</p>
            <%
                if( request.getParameter( "submit" ) == null ) {
                        out.print( gui.forgotPassForm( ) );
                }
                else {
                    Email email = new Email( );
                    boolean emailSent = email.sendPasswordToUser( request.getParameter( "id_number" ), request.getParameter( "token" ) );

                    if( emailSent ){
                        out.print( "<p>You have been sent a link to reset your password</p>" );
                        out.print( "<a href=\"index.jsp\">Back to home page!</a>" );
                    }
                    else{
                        out.print( gui.forgotPassForm( ) );
                        out.print( "<p>ID does not exist, please try again! </p>" );
                    }
                }
            %>    
        </div> 
        
        <%
            out.print( gui.footer( ) );
        %>    
    </body>
</html>
