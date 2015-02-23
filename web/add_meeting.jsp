<%-- 
    Document   : add_event.jsp
    Created on : 09-Feb-2015, 18:35:04
    Author     : Martin Bullman 112735341
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="application.User;" %>
<%@ page import="guipackage.GUI;"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styles.css" media="screen" type="text/css" />
        <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,300italic' rel='stylesheet' type='text/css'>
        <title>Add Event</title>
    </head>
    
    <body>
        <%
          GUI gui = new GUI( );  
          out.print( gui.header( false, "blank", "blank" ) );
        %> 
        
        <div class="login-card">
            <h1>Add A New Event!</h1>
        
            <jsp:useBean id="meeting" class="application.AddMeeting" scope="request" />
            <jsp:setProperty name="meeting" property="*" />
   
            <%
                if( session.getAttribute( "Authenticated" ) == null ) {
                    response.sendRedirect( "index.jsp" );
                }
                else {
                    String userId = (String) session.getAttribute( "Authenticated" );
                    
                    if( request.getParameter( "submit" ) == null ) {
                        out.print( meeting.addMeetingForm( userId ) );
                    }
                    else {
                        if( meeting.validateMeetingForm( userId ) ) {
                            out.print( "Your event has be saved successfully!" );
                            out.print( "<a href='timetable.jsp'>Back to Timetable!</a>" );
                        }
                        else {
                            out.print( meeting.addMeetingForm( userId ) );
                            out.print( meeting.errors( ) );
                        }
                    }
                }
            %>
        </div>
      
        <%
          out.print( gui.footer( ) );
        %>  
    </body>
</html>
