<%-- 
    Document   : erro
    Created on : 04/05/2016, 15:20:42
    Author     : Alexandre Lopes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <h1 style="position: absolute; top: 200px;">Erro: ${msgErro}</h1>
    </body>
</html>
