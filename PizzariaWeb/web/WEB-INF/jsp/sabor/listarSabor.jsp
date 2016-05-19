<%-- 
    Document   : listarSabor
    Created on : 17/05/2016, 09:43:26
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
            <h1>Sabores</h1><hr>
            <a href="${pageContext.request.contextPath}/sabor!novo.action">Novo</a><br><br><hr>
            <ul style="list-style: none;">
                <c:forEach var="sabor" items="${sabores}">
                    <li>Tipo: ${sabor.tipo.nome} - <b><c:out value="${sabor.nome}"/></b>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/sabor!alterar.action?codigo=${sabor.codigo}&cod_tipo=${sabor.tipo.codigo}">alterar</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/sabor!remover.action?codigo=${sabor.codigo}">remover</a></li>                               
                </c:forEach>
            </ul>
            <hr>
            <footer>
                Desenvolvido por Alexandre Barbieri e Felipe Teixeira
            </footer>
        </article>
    </body>
</html>
