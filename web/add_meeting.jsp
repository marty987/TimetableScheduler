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
        
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
        
        <script>
            $( function( ) {
              $( ".datepicker" ).datepicker( { dateFormat: "yy/mm/dd" } );
            });
        </script>
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
                        out.print( meeting.addMeetingForm( userId, request ) );
                    }
                    else {
                        if( meeting.validateMeetingForm( userId, ( String[] ) session.getAttribute("groupMembers") ) ) {
                            out.print( "Your event has be saved successfully!" );
                            out.print( "<a id='back' href='timetable.jsp'>Back to Timetable!</a>" );
                        }
                        else {
                            out.print( meeting.addMeetingForm( userId, request) );
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