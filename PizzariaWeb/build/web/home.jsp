<%-- 
    Document   : home
    Created on : 04/05/2016, 15:20:34
    Author     : Alexandre Lopes
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pizzaria - Home</title>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <c:if test="${usuario == null}">
            <c:redirect url="index.jsp"></c:redirect>
        </c:if>
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <div style="border-radius: 8px; color: #4F8A10; width: 90%; background-color: #DFF2BF; margin-top: 10px; padding: 5px; font-weight: bold;">Bem-vindo(a) ${usuario.nomeUsuario}!</div>
        <footer>
            Desenvolvido por Alexandre Barbieri e Felipe Teixeira
        </footer>
    </body>

</html>
