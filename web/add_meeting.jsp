<%-- 
    Document   : add_event.jsp
    Created on : 09-Feb-2015, 18:35:04
    Author     : Martin Bullman 112735341
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="application.Register;" %>
<%@ page import="guipackage.GUI;"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styles.css" media="screen" type="text/css" />
        <title>Add Event</title>
    </head>
    <body>
        
        <%
          GUI header = new GUI();  
          out.print( header.header() );
        %> 
        
      <div class="login-card">
        <h1>Add A New Event!</h1>
        
        <jsp:useBean id="meeting" class="application.AddMeeting" scope="request" />
        <jsp:setProperty name="meeting" property="*" />
        
        <%
            if( request.getParameter( "submit" ) == null ) {
                out.print( meeting.addMeetingForm( ) );
            }
            else {
                if( meeting.validateMeetingForm( ) ) {
                    response.sendRedirect( "timetable.jsp" );  
                }
                out.print( meeting.addMeetingForm( ) );
                out.print( meeting.errors( ) );
            }
        %>
      </div>
      
        <%
          GUI footer = new GUI();  
          out.print( footer.footer() );
        %>  
    </body>
</html>
