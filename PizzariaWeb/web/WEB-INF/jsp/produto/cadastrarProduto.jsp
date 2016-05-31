<%-- 
    Document   : cadastrarProduto
    Created on : 20/05/2016, 13:29:02
    Author     : Inmetrics
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pizzaria - Novo Produto</title>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../../jspf/header.jspf" %>
        <article>
            <section id="cadastro">
                <form method="POST" action="${pageContext.request.contextPath}/produto!cadastrar.action">
                    <fieldset>
                        <legend>Cadastrar Produto</legend>
                        
                        <h5 style="display: inline;">Sabor</h5><br>
                        <select name="sabor" style="width: 150px;">
                            <c:forEach var="sabor" items="${sabores}">
                                <option value="${sabor.codigo}">${sabor.nome}</option>
                            </c:forEach>
                        </select>
                        <br>
                        <input type="text" name="nome" placeholder="Nome" required="required"><br>
                        <input type="text" name="descricao" placeholder="Descrição" required="required"><br>
                        <input type="text" name="preco" placeholder="Preço" required="required"><br>
                        
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