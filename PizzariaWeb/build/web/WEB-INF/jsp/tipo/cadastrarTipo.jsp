<%-- 
    Document   : index.jsp
    Created on : 27/04/2016, 22:25:37
    Author     : Alexandre Lopes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pizzaria - Novo Tipo</title>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../../jspf/header.jspf" %>
        <article>
            <section id="cadastro">
                <form method="POST" action="${pageContext.request.contextPath}/tipo!cadastrar.action">
                    <fieldset>
                        <legend>Cadastrar Tipo</legend>
                        <label>Nome do Tipo</label>
                        <input type="text" name="nome" placeholder="Nome" required="required"><br>
                        <input type="submit" value="Cadastrar">
                    </fieldset>
                </form>
            </section>

            <footer>
                Desenvolvido por Alexandre Barbieri e Felipe Teixeira
            </footer>
        </article>
    </body>
</html>
