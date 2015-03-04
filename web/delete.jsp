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
              out.print( "<div class='table2'>" );
              out.print( "<div class='card'>" );   

              String event_Id = request.getParameter( "event_id" );
                 
               // if( request.getParameter( "delete_event" ) == null ){
                       delete.eventInfo(event_Id);
                       delete.printDeleteForm(event_Id);
                       System.out.println(delete.printInfo());
               // }

              //  else{

               // }
             
              
              out.print( "</div>" );
              out.print( "</div>" );

          }
          out.print( gui.footer() );
        %>
    </body>
</html>
