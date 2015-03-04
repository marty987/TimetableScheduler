<%-- 
    Document   : delete
    Created on : 03-Mar-2015, 16:03:56
    Author     : jd7
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="guipackage.GUI;"%>
<%@ page import="application.Delete;"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styles.css" media="screen" type="text/css" />
        <link rel="stylesheet" href="css/timetable.css" media="screen" type="text/css" />
        <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,300italic' rel='stylesheet' type='text/css'>
        <title>Delete Meeting</title>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
    </head>
    <body>

        <%
          Delete delete = new Delete();
          GUI gui = new GUI( );  
          out.print( gui.header( false, "blank", "blank" ) );
          if( session.getAttribute( "Authenticated" ) == null ) {
                response.sendRedirect( "index.jsp" );
          } 
          
          else {
 

              String event_Id = request.getParameter( "event_id" );
                 
               if( request.getParameter( "delete_event" ) == null ){
                   out.print( "<div class='table2'>" );
                   
                   delete.eventInfo(event_Id);
                   out.println(delete.printInfo());
                                 
                 
                   out.print( "</div>" );
               }

              else{
                   
                   
                   out.print( "<div class='login-card'>" );
                   //delete.eventInfo(event_Id);
                   delete.deleteEvent( (String) session.getAttribute( "Authenticated" ) );
                   out.println("Your event has been deleted");
                   out.print( "<a id='back' href='timetable.jsp'>Back to Timetable!</a>" );
                   out.print( "</div>" );
               }

          }
          out.print( gui.footer() );
        %>
    </body>
</html>
