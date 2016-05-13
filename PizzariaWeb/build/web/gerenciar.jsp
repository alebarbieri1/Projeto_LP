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
        <title>JSP Page</title>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <c:if test="${usuario == null}">
            <c:redirect url="index.jsp"></c:redirect>
        </c:if>
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <h1>Painel de Controle</h1>
            <h3 style="color: blue;">Tipo</h3>
            <a href="${pageContext.request.contextPath}/tipo!listar.action">Listar</a>
        <footer>
            <h3>Desenvolvido por Alexandre Barbieri e Felipe Teixeira</h3>
        </footer>
    </body>
</html>
