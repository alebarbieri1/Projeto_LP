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
        <title>Pizzaria</title>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <article>
            <c:if test="${usuario == null}">
                <section id="cadastro">
                    <form method="POST" action="Controller">
                        <fieldset>
                            <legend>Cadastre-se</legend>
                            <label>Nome Completo</label><input type="text" name="nome" placeholder="Nome" required="required"><br>
                            <label>CPF</label><input type="text" name="cpf" placeholder="CPF" required="required"><br>
                            <label>Usuário</label><input type="text" name="nome_usuario" placeholder="Usuário" required="required"><br>
                            <label>Senha</label><input type="password" name="senha" placeholder="Senha" required="required"><br>
                            <label>Endereço</label><input type="text" name="endereco" placeholder="Endereço" required="required"><br>
                            <label>Telefone</label><input type="text" name="telefone" placeholder="Telefone" required="required"><br>
                            <label>CEP</label><input type="text" name="cep" placeholder="CEP" required="required"><br>
                            <input type="hidden" name="command" value="usuario!cadastrar"/>
                            <input type="submit" value="Cadastrar-se">
                        </fieldset>
                    </form>
                </section>
            </c:if>
            <c:if test="${usuario != null}">
                <h1>Confira as promoções de hoje :)</h1>
            </c:if>
            <footer>
                <h3>Desenvolvido por Alexandre Barbieri e Felipe Teixeira</h3>
            </footer>
        </article>
    </body>
</html>
