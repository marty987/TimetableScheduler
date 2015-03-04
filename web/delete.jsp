<%-- 
    Document   : delete
    Created on : 03-Mar-2015, 16:03:56
    Author     : jd7
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="guipackage.GUI;"%>
<%@ page import="algorithm.FindMeeting;"%>
<%@ page import="application.Delete;"%>
<%@ page import="java.util.ArrayList;"%>

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
          
          out.print( "<div id='sidebar'>" );               
                out.print( "<a class='add_meeting' href='add_meeting.jsp'><h1>Add meeting</h1></a>" );
                out.print( "<h4>Find an available time slot</h4>" );
                 
                FindMeeting meeting = new FindMeeting( );
                
                if( meeting.isLecturer( ( String ) session.getAttribute( "Authenticated" ) ) ) {
                    if( request.getParameter( "find_meeting" ) == null ){
                        out.print( meeting.findMeetingForm(  ) );
                    }
                    else {
                        if( meeting.processFindSlotFormData( request ) ) {
                            ArrayList<Integer> freeMeetingPeriods = meeting.getFreeSlot( request );

                            if( freeMeetingPeriods.isEmpty( ) ){
                                out.print( "<p>No free time for group available on this day, Please try another day!</p>" );
                            }
                            else{
                                out.print( freeMeetingPeriods );
                                session.setAttribute("groupMembers", meeting.getGroupMembers( ));
                                out.print( meeting.pickAvailablePeriodFrom( request.getParameter( "pick_stream" ), request.getParameter( "date" )  ) );
                                //response.sendRedirect( "add_meeting.jsp" );
                            }
                        }
                        else {
                            out.print( meeting.findMeetingForm( ) );
                            out.print( meeting.errors( ) );
                        }
                    }
                }
                
                if( request.getParameter( "get_members" ) == null) {
                    out.print( meeting.groupFrom(  ) );
                }   
                else {
                    if( meeting.validatePrivateGroupForm( request ) ) {
                        if( meeting.checkGroupMembers( ) ) {
                            ArrayList<Integer> freeMeetingPeriods = meeting.getFreeSlot( request );
                            
                            if( freeMeetingPeriods.isEmpty( ) ){
                                out.print( "<p>No free time for group available on this day, Please try another day!</p>" );
                            }
                            else{
                                out.print( freeMeetingPeriods );
                                session.setAttribute("groupMembers", meeting.getGroupMembers( ));
                                out.print( meeting.pickAvailablePeriodFrom( request.getParameter( "pick_stream" ), request.getParameter( "date" )  ) );
                                //response.sendRedirect( "add_meeting.jsp" );
                            }
                        }
                        else 
                        {
                            out.print("<p> One of the members does not exist in the database. Please try again. </p>");
                        }
                    }
                    else {
                        out.print( meeting.groupFrom(  ) );
                        out.print( meeting.errors( ) );
                    }
                }
                
          out.print( "</div>");
          
          
          
          if( session.getAttribute( "Authenticated" ) == null ) {
                response.sendRedirect( "index.jsp" );
          } 
          else {
               if( request.getParameter( "delete_event" ) == null ){
                   
                   String event_Id = request.getParameter( "event_id" );
                   delete.setEventId( event_Id );
                   
                   session.setAttribute("eventid", event_Id );
                   
                   out.print( "<div class='table'>" );
                   out.print( "<div class='card'>" );  
                   delete.eventInfo(event_Id);
                   out.println(delete.printInfo());
                                 
                 
                   out.print( "</div>" );
               }

              else{
                   System.out.println( "session event id : " +  session.getAttribute("eventid") );
                   
                   out.print( "<div class='login-card'>" );
                   //delete.eventInfo(event_Id);
                   delete.deleteEvent( (String) session.getAttribute( "Authenticated" ), (String) session.getAttribute( "eventid" ) );
                   out.println("Your event has been deleted");
                   out.print( "<a id='back' href='timetable.jsp'>Back to Timetable!</a>" );
                   out.print( "</div>" );
               }

          }
          out.print( gui.footer() );
        %>
    </body>
</html>
