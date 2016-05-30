<%-- 
    Document   : listarPizza
    Created on : 27/05/2016, 20:41:46
    Author     : Inmetrics
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pizzaria - Pizzas</title>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../../jspf/header.jspf" %>
        <article>
            <h1>Pizzas</h1><hr>
            <form action="${pageContext.request.contextPath}/pedido!finalizar.action" method="POST">
                <c:forEach var="pizza" items="${produtos}">
                    <img src="${pageContext.request.contextPath}/imgs/pizza2.jpg" alt="" width="222" height="114"/><br>
                    <b>Sabor:</b> ${pizza.sabor.nome}<br>
                    <b>Nome do produto: </b>${pizza.nome}<br>
                    <b>Preço do produto: </b>R$ ${pizza.preco}<br>
                    <b>Selecionar: </b><input style="transform: scale(1.5);" type="checkbox" name="selecionados" value="${pizza.codigo}">
                    <br><br><hr>
                </c:forEach>
                    <input type="hidden" name="usuario" value="${usuario.codigo_usuario}">
                    <input style="padding: 15px;" type="submit" value="Finalizar Pedido">
                    <br><br><hr>
            </form>
        </article>
        <footer>
            Desenvolvido por Alexandre Barbieri e Felipe Teixeira
        </footer>
    </body>
</html>

