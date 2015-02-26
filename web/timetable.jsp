<%-- 
    Document   : timetable.jsp
    Created on : 09-Feb-2015, 16:44:55
    Author     : Jack Desmond
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="notifications.UsersNotifications;" %>
<%@ page import="algorithm.FindMeeting;" %>
<%@ page import="application.Timetable;" %>
<%@ page import="guipackage.GUI;"%>
<%@ page import="guipackage.GUI;"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styles.css" media="screen" type="text/css" />
        <link rel="stylesheet" href="css/timetable.css" media="screen" type="text/css" />
        <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,300italic' rel='stylesheet' type='text/css'>
        <title>UCC Timetable</title>
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
        <script type="text/javascript" src="js/table.js"></script>
        

    
    <body>
        <div class="time">
        <%
            GUI gui = new GUI( );
            
            if( session.getAttribute( "Authenticated" ) == null ) {
                response.sendRedirect( "index.jsp" );
            }
            else {
                String fname = (String) session.getAttribute( "firstName" );
                String lname = (String) session.getAttribute( "lastName" );
                out.print(gui.header(true, fname, lname));
                
                Timetable timetable = new Timetable( );
                out.print( "<div class='divid'>" );
                out.print( timetable.printTimetable( ) );      
                out.print( "</div>" );
            }
        %>  
        </div>
        
        <section>
            
            
            <%
                out.print( "<div class='divid2'>" );
                out.print( "<h1 class='notifications'>Notifications</h1><a class='add_meeting' href='add_meeting.jsp'>Add Meeting</a>" );
                UsersNotifications notify = new UsersNotifications( );
                out.print( notify.getUsersNotifications( (String) session.getAttribute( "Authenticated" ) ) );
                
                if( request.getParameter( "seen_events" ) != null ){
                    
                    notify.hasSeen( request );
                    response.sendRedirect( "timetable.jsp" );
                }
                out.print( "</div>" );
            %>
        </section>
        
        <section>
            <%
                FindMeeting meeting = new FindMeeting( );
                
                if( request.getParameter( "find_meet" ) == null ){
                    out.print( meeting.findMeetingForm( (String) session.getAttribute( "Authenticated" ) ) );
                }
                else{
                    out.print( meeting.getFreeSlot( request.getParameter( "startDate" ), request.getParameter( "stream" ) ) );
                 }
            %>
        </section>
        
        
        <section>
            <h1>Chat Room</h1>
            
        </section>
        
        <%
             out.print( gui.footer() );
        %>
    </body>
</html>
