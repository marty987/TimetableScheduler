<%-- 
    Document   : add_friend
    Created on : 25-Feb-2015, 16:58:53
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
        <title>Add Friend</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    </head>
    <body>
        <%
          GUI gui = new GUI();  
          out.print( gui.header( false, "blank", "blank" ) );
        %>
        <div class="login-card">
            <jsp:useBean id="friend" class="application.AddFriend" scope="request" />
            <jsp:setProperty name="friend" property="*" />
            <h1>Add a friend to chat with!</h1>
            <%
              if( session.getAttribute( "Authenticated" ) == null ) {
                  response.sendRedirect( "index.jsp" );
              } else {
                  String userId = (String) session.getAttribute( "Authenticated" );
                  
                  if( request.getParameter( "submit" ) == null ) {
                      out.print( friend.addFriendForm( userId ) );
                  } else {
                      if( friend.validateAddingFriendForm( userId ) ) {
                          out.print( "Friend added successfully!" );
                          out.print( "<a href='timetable.jsp'>Back to Timetable!</a>" );
                      } else {
                          out.print( friend.addFriendForm( userId ) );
                          out.print( friend.errors( ) );
                      }
                  }
              }
            %>
        </div>
        <%
          out.print(gui.footer());
        %> 
    </body>
</html>