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
        <title>Pizzaria - Tipos</title>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../../jspf/header.jspf" %>
        <article>
            <h1>Tipos</h1><hr>
            <a href="${pageContext.request.contextPath}/tipo!novo.action" class="botaoNovo">Novo</a><br><br><hr>
            <table style="width: 50%; margin-left: 25%;">
                <thead>
                <th>Tipo</th>
                <th>Editar</th>
                <th>Remover</th>
                </thead>
                <tbody>
                    <c:forEach var="tipo" items="${tipos}">
                        <tr>
                            <td>${tipo.nome}</td>
                            <td><a href="${pageContext.request.contextPath}/tipo!alterar.action?codigo=${tipo.codigo}"><img src="${pageContext.request.contextPath}/imgs/iconeEditar.png" alt="Editar" title="Editar"/></a></td>      
                            <td><a href="${pageContext.request.contextPath}/tipo!remover.action?codigo=${tipo.codigo}"><img src="${pageContext.request.contextPath}/imgs/iconeRemover.png" alt="Remover" title="Remover"/></a></td>
                        </tr>                     
                    </c:forEach>
                </tbody>
            </table>
            <hr>
            <footer>
                Desenvolvido por Alexandre Barbieri e Felipe Teixeira
            </footer>
        </article>
    </body>
</html>

