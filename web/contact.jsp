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
            
            <jsp:useBean id="contact" class="application.Contact" scope="request" />
            <jsp:setProperty name="contact" property="*" />
        <div class="login-card">
            <h1>Contact Us</h1>
            <%
                
                if( request.getParameter( "submit" ) == null ) {
                    out.print( contact.contactForm( ) );
                    
                }
                else {
                    if( contact.validateContactForm( ) ) {
                        out.print( "<p>You message has been sent.</p>" );
                        out.print( "<p><a href='timetable.jsp'>Go to your Timetable!</a></p>" );
                    }
                    out.print( contact.contactForm( ) );
                    out.print( contact.errors( ) );
                }
            %>
        </div>
        
        <%
          GUI footer = new GUI();  
          out.print( footer.footer() );
        %>        
    </body>
</html>

