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
                    <form method="POST" action="${pageContext.request.contextPath}/usuario!cadastrar.action">
                        <fieldset>
                            <legend style="font-size: 18px;">Cadastro</legend>
                            <label>Nome Completo</label><input type="text" name="nome" placeholder="Nome" required="required"><br>
                            <label>CPF</label><input type="text" name="cpf" placeholder="CPF" required="required"><br>
                            <label>Usuário</label><input type="text" name="nome_usuario" placeholder="Usuário" required="required"><br>
                            <label>Senha</label><input type="password" name="senha" placeholder="Senha" required="required"><br>
                            <label>Endereço</label><input type="text" name="endereco" placeholder="Endereço" required="required"><br>
                            <label>Telefone</label><input type="text" name="telefone" placeholder="Telefone" required="required"><br>
                            <label>CEP</label><input type="text" name="cep" placeholder="CEP" required="required"><br>
                            &nbsp;&nbsp;&nbsp;<label>Tipo de Usuário</label> <input type="radio" style="transform: scale(1.5);"  name="acesso" value="0" checked="checked"> Comum &nbsp; <input type="radio" style="transform: scale(1.5);" name="acesso" value="1"> Administrador<br><br>
                            <input type="submit" value="Cadastrar-se">
                        </fieldset>
                    </form>
                </section>
            </c:if>
            <c:if test="${usuario != null}">
                <h1>Seja bem-vindo à Pizzaria ...</h1><br>
                <img src="imgs/pizza1.jpg" alt="Pizza" title="Pizza"/>
            </c:if>
            <footer>
                Desenvolvido por Alexandre Barbieri e Felipe Teixeira
            </footer>
        </article>
    </body>
</html>
