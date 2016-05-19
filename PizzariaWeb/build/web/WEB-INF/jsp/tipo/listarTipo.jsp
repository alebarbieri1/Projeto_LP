<%-- 
    Document   : listarTipoo
    Created on : 10/05/2016, 09:41:47
    Author     : Inmetrics
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
        <%@include file="../../jspf/header.jspf" %>
        <article>
            <h1>Tipos</h1><hr>
            <a href="${pageContext.request.contextPath}/tipo!novo.action">Novo</a><br><br><hr>
            <ul style="list-style: none;">
                <c:forEach var="tipo" items="${tipos}">
                    <li><b><c:out value="${tipo.nome}"/></b>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/tipo!alterar.action?codigo=${tipo.codigo}">alterar</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/tipo!remover.action?codigo=${tipo.codigo}">remover</a></li>                               
                </c:forEach>
            </ul>
            <hr>
            <footer>
                Desenvolvido por Alexandre Barbieri e Felipe Teixeira
            </footer>
        </article>
    </body>
</html>

