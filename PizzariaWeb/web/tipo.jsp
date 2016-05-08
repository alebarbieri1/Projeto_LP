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
        <title>Tipo</title>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <article>
            <section id="cadastro">
                <form method="POST" action="Controller">
                    <fieldset>
                        <legend>Cadastrar</legend>
                        <label>Nome do Tipo</label><input type="text" name="nome" placeholder="Nome" required="required"><br>
                        <input type="hidden" name="command" value="tipo!cadastrar"/>
                        <input type="submit" value="Cadastrar">
                    </fieldset>
                </form>
            </section>

            <footer>
                <h3>Desenvolvido por Alexandre Barbieri e Felipe Teixeira</h3>
            </footer>
        </article>
    </body>
</html>
