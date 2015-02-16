<%-- 
    Document   : forgot_password.jsp
    Created on : Feb 12, 2015, 11:41:10 PM
    Author     : Martin Bullman 112735341
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="guipackage.GUI;"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styles.css" media="screen" type="text/css" />
        <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,300italic' rel='stylesheet' type='text/css'>        
        <title>Forgot Password!</title>
    </head>
    
    <body>
       <%
          GUI gui = new GUI();  
          out.print( gui.loginHeader() );
        %>  
        
        <h1>You forgot your password again!</h1>
        <h2>What a douche!!!</h2>
        
        <%
          out.print( gui.forgotPassForm() );
          out.print( gui.footer( ) );
        %>    
    </body>
</html>
