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
        <div style="border-radius: 8px; color: #D63301; width: 90%; background-color: #FFCCBA; margin-top: 10px; padding: 5px; font-weight: bold;">Erro: ${msgErro}</div>
        <footer>
            Desenvolvido por Alexandre Barbieri e Felipe Teixeira
        </footer>
    </body>
</html>
