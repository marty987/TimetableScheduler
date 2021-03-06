<%-- 
    Document   : timetable.jsp
    Created on : 09-Feb-2015, 16:44:55
    Author     : Jack Desmond, Martin Bullman 112735341 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="notifications.UsersNotifications;" %>
<%@ page import="algorithm.FindMeeting;" %>
<%@ page import="application.Timetable;" %>
<%@ page import="guipackage.GUI;"%>
<%@ page import="chatpackage.FriendRequests;"%>
<%@ page import="java.util.ArrayList;"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styles.css" media="screen" type="text/css" />
        <link rel="stylesheet" href="css/timetable.css" media="screen" type="text/css" />
        <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,300italic' rel='stylesheet' type='text/css'>
        <title>UCC Timetable</title>
        
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
            
            if( session.getAttribute( "Authenticated" ) == null ) {
                response.sendRedirect( "index.jsp" );
            }
            else {
                String username = (String) session.getAttribute( "Authenticated" );
                String fname = (String) session.getAttribute( "firstName" );
                String lname = (String) session.getAttribute( "lastName" );
                out.print(gui.header(true, fname, lname));
                
                out.print( "<div id='sidebar'>" );               
                out.print( "<a class='add_meeting' href='add_meeting.jsp'><h1>Add meeting</h1></a>" );
                 
                FindMeeting meeting = new FindMeeting( );
                
                if( meeting.isLecturer( ( String ) session.getAttribute( "Authenticated" ) ) ) {
                    if( request.getParameter( "find_meeting" ) == null ){
                        out.print( "<h4>Find an available time slot</h4>" );
                        out.print( meeting.findMeetingForm(  ) );
                    }
                    else {
                        if( meeting.processFindSlotFormData( request ) ) {
                            ArrayList<Integer> freeMeetingPeriods = meeting.getFreeSlot( request );

                            if( freeMeetingPeriods.isEmpty( ) ){
                                out.print( "<p>No free time for group available on this day, Please try another day!</p>" );
                            }
                            else{
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
                                session.setAttribute("groupMembers", meeting.getGroupMembers( ));
                                out.print( meeting.pickAvailablePeriodFrom( request.getParameter( "pick_stream" ), request.getParameter( "date" )  ) );
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
                out.print( "<div class='card'>" );   
                out.print( "<div class='time'>" );
                Timetable timetable = new Timetable( );
                out.print( timetable.printTimetable( username ) );      
                out.print( "</div>" );
                session.setAttribute("eventId", timetable.getEventId());
                session.setAttribute("eventName", timetable.getEventName());
            }
        %>  

        <section>     
            <%
                UsersNotifications notify = new UsersNotifications( );
                out.print( notify.getUsersNotifications( (String) session.getAttribute( "Authenticated" ) ) );
                
                if( request.getParameter( "seen_events" ) != null ){
                    notify.hasSeen( request );
                    response.sendRedirect( "timetable.jsp" );
                }
                out.print( "</div>" );
            %>
        </section>
        
<!--        <section>
//            <%
//                FriendRequests friends = new FriendRequests();
//                out.print(friends.getFriendsAndRequests((String)session.getAttribute("Authenticated")));
//                
//                // lots of stuff to do
//                
//                out.print( "</div>" );
//            %>
        </section> -->
        
        <%
             out.print( gui.footer() );
        %>
    </body>
</html>
