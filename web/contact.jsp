<%-- 
    Document   : contact
    Created on : 16-Feb-2015, 11:51:43
    Author     : Delaney
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="guipackage.GUI;"%>
<%@ page import="application.Contact;"%>
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
            
            <jsp:useBean id="message" class="application.Contact" scope="request" />
            <jsp:setProperty name="message" property="*" />
        <div class="login-card">
            <h1>Contact Us</h1>
            <%

                if( request.getParameter( "submit" ) == null ) {
                    out.print( message.addContactForm(  ) );
                }
                else {
                    if( message.validateContactForm( ) ) {
                        out.print( "<p>You have successfully sent your message, we shall be in contact shortly.</p>!" );
                        out.print( "<p><a href='index.jsp'>Go to your Timetable!</a></p>" );
                    }
                    out.print( message.addContactForm( ) );
                    out.print( message.printErrors( ) );
                }
            %>
        </div>
        
        <%
          GUI footer = new GUI();  
          out.print( footer.footer() );
        %>        
    </body>
</html>

