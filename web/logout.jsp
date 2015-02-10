<%-- 
    Document   : logout
    Created on : 10-Feb-2015, 14:44:03
    Author     : jd7
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styles.css" media="screen" type="text/css" />
        <title>Logout</title>
    </head>
    <body>
        <h1>Logout successful</h1>
        <%
            session.invalidate();
        %>
        <p><a href="index.jsp">Log back in</a></p>
    </body>
</html>