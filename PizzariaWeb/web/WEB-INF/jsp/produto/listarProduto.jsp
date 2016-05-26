<%-- 
    Document   : listarProduto
    Created on : 20/05/2016, 13:28:30
    Author     : Inmetrics
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pizzaria - Produtos</title>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../../jspf/header.jspf" %>
        <article>
            <h1>Produtos</h1><hr>
            <a href="${pageContext.request.contextPath}/produto!novo.action" class="botaoNovo">Novo</a><br><br><hr>
            <table  style="width: 50%; margin-left: 25%;">
                <thead>
                <th>Sabor</th>
                <th>Produto</th>
                <th>Descrição</th>
                <th>Preco</th>
                <th>Editar</th>
                <th>Remover</th>
                </thead>
                <tbody>
                    <c:forEach var="produto" items="${produtos}">
                        <tr>
                            <td>${produto.sabor.nome}</td>
                            <td>${produto.nome}</td>
                            <td>${produto.descricao}</td>
                            <td>${produto.preco}</td>
                            <td><a href="${pageContext.request.contextPath}/produto!alterar.action?codigo=${produto.codigo}&cod_sabor=${produto.sabor.codigo}"><img src="${pageContext.request.contextPath}/imgs/iconeEditar.png" alt="Editar" title="Editar"/></a></td>
                            <td><a href="${pageContext.request.contextPath}/produto!remover.action?codigo=${produto.codigo}"><img src="${pageContext.request.contextPath}/imgs/iconeRemover.png" alt="Remover" title="Remover"/></a></td>
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
