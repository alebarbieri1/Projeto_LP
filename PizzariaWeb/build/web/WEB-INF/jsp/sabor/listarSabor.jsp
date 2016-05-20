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
        <title>Pizzaria - Sabores</title>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../../jspf/header.jspf" %>
        <article>
            <h1>Sabores</h1><hr>
            <a href="${pageContext.request.contextPath}/tipo!novo.action" class="botaoNovo">Novo</a><br><br><hr>
            <table  style="width: 50%; margin-left: 25%;">
                <thead>
                <th>Tipo</th>
                <th>Sabor</th>
                <th>Descrição</th>
                <th>Editar</th>
                <th>Remover</th>
                </thead>
                <tbody>
                    <c:forEach var="sabor" items="${sabores}">
                        <tr>
                            <td>${sabor.tipo.nome}</td>
                            <td>${sabor.nome}</td>
                            <td>${sabor.descricao}</td>
                            <td><a href="${pageContext.request.contextPath}/sabor!alterar.action?codigo=${sabor.codigo}&cod_tipo=${sabor.tipo.codigo}"><img src="${pageContext.request.contextPath}/imgs/iconeEditar.png" alt="Editar" title="Editar"/></a></td>
                            <td><a href="${pageContext.request.contextPath}/sabor!remover.action?codigo=${sabor.codigo}"><img src="${pageContext.request.contextPath}/imgs/iconeRemover.png" alt="Remover" title="Remover"/></a></td>
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
