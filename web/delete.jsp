<%-- 
    Document   : delete
    Created on : 03-Mar-2015, 16:03:56
    Author     : jd7
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="guipackage.GUI;"%>
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
        <jsp:useBean id="delete" class="application.Delete" scope="request" />
        <%
          GUI gui = new GUI( );  
          out.print( gui.header( false, "blank", "blank" ) );
          if( session.getAttribute( "Authenticated" ) == null ) {
                response.sendRedirect( "index.jsp" );
          } else {
              int eventId = (Integer) session.getAttribute( "eventId" );
              String eventName = (String) session.getAttribute( "eventName" );
              out.println(eventId);
              out.println(eventName);
//              delete.printDeleteForm(eventId, eventName);
          }
          out.print( gui.footer() );
        %>
    </body>
</html>
