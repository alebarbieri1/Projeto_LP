<%-- 
    Document   : index.jsp
    Created on : 27/04/2016, 22:25:37
    Author     : Inmetrics
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pizzaria</title>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header>
            <ul>
                <li><a href="/pizzaria">Pizzaria</a></li>
                <li><a href="#">Pizzas</a></li>
                <li><a href="#">Outros Produtos</a></li>
                <li><a href="#">Promoções</a></li>
                <li><a href="#">Entregas</a></li>
                <li><a href="#">Sobre</a></li>
            </ul>
            <section>
                <form method="POST" action="Controller">
                    <input type="text" placeholder="Usuário" required="required"><br>
                    <input type="password" placeholder="Senha" required="required"><br>
                    <input type="submit" value="Login"><br>
                </form> 
            </section>
        </header>
    </body>
</html>
