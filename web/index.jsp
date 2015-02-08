<%-- 
    Document   : index
    Created on : Feb 8, 2015, 12:56:25 PM
    Author     : Marty2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome, Please Login</h1>
        <jsp:useBean id="login" class="application.Login" scope="session" />
        <jsp:setProperty name="login" property="*" />
        
        <%
            
        %>
    </body>
</html>
