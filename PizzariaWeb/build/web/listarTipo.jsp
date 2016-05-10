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
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <article>
            <h1>Tipos</h1><hr>
            <a href="cadastraTipo.jsp">Novo</a><br><br><hr>
            <ul>
                <c:forEach var="tipo" items="${tipos}">
                    <li><b><c:out value="${tipo.nome}"/></b>&nbsp;&nbsp;<a href="TipoBusiness?codigo=${tipo.codigo}&command=alterar">alterar</a>&nbsp;&nbsp;<a href="TipoBusiness?codigo=${tipo.codigo}&command=remover">remover</a></li>                               
                </c:forEach>
            </ul>
            <hr>
            <footer>
                <h3>Desenvolvido por Alexandre Barbieri e Felipe Teixeira</h3>
            </footer>
        </article>
    </body>
</html>

