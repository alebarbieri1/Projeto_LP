<%-- 
    Document   : listarPedido
    Created on : 30/05/2016, 20:18:51
    Author     : Inmetrics
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pizzaria - Pedidos</title>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../../jspf/header.jspf" %>
        <article>
            <h1 style="color: green;">Pedido Finalizado</h1><hr>
            <b>Preço total: R$ ${pedido.precoTotal}</b><br><hr>
            <c:forEach var="item" items="${pedido.itensPedido}">
                <b>Nome do Produto: </b> ${item.produto.nome}<br>
                <b>Quantidade: </b> ${item.quantidade}<br>
                <b>Preço do Produto: </b> ${item.quantidade} * R$ ${item.produto.preco} = R$ ${item.produto.preco}
                <br>
                <hr>
            </c:forEach>
        </article>
        <footer>
            Desenvolvido por Alexandre Barbieri e Felipe Teixeira
        </footer>
    </body>
</html>