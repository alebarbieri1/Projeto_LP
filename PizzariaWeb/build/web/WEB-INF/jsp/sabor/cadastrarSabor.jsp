<%-- 
    Document   : cadastrarSabor
    Created on : 17/05/2016, 09:47:04
    Author     : Inmetrics
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pizzaria - Novo Sabor</title>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../../jspf/header.jspf" %>
        <article>
            <section id="cadastro">
                <form method="POST" action="${pageContext.request.contextPath}/sabor!cadastrar.action">
                    <fieldset>
                        <legend>Cadastrar Sabor</legend>
                        
                        <h5 style="display: inline;">Tipo</h5><br>
                        <select name="tipo" style="width: 150px;">
                            <c:forEach var="tipo" items="${tipos}">
                                <option value="${tipo.codigo}">${tipo.nome}</option>
                            </c:forEach>
                        </select>
                        <br>
                        <input type="text" name="nome" placeholder="Nome" required="required"><br>
                        <input type="text" name="descricao" placeholder="Descrição" required="required"><br>
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