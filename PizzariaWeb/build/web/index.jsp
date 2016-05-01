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
        <header>
            <ul>
                <li><a href="/pizzaria">Pizzaria</a></li>
                <li><a href="#">Pizzas</a></li>
                <li><a href="#">Outros Produtos</a></li>
                <li><a href="#">Promoções</a></li>
                <li><a href="#">Entregas</a></li>
                <li><a href="#">Sobre</a></li>
            </ul>
            <section id="login">
                <form method="POST" action="Controller">
                    <input type="text" placeholder="Usuário" required="required" name="usuario"><br>
                    <input type="password" placeholder="Senha" required="required" name="senha"><br>
                    <input type="submit" value="Login"><br>
                </form> 
            </section>
        </header>
        <article>
            <section id="cadastro">
                <form method="POST" action="#">
                    <fieldset>
                        <legend>Cadastre-se</legend>
                        <label>Nome Completo</label><input type="text" name="nome" placeholder="Nome" required="required"><br>
                        <label>Usuário</label><input type="text" name="usuario" placeholder="Usuário" required="required"><br>
                        <label>Senha</label><input type="password" name="senha" placeholder="Senha" required="required"><br>
                        <label>E-mail</label><input type="email" name="email" placeholder="E-mail" required="required"><br>
                        <label>Endereço</label><input type="text" name="endereco" placeholder="Endereço" required="required"><br>
                        <label>Cidade</label><input type="text" name="cidade" placeholder="Cidade" required="required"><br>
                        <label>CEP</label><input type="text" name="cep" placeholder="CEP" required="required"><br>
                        <label>Telefone Residencial</label><input type="tel" name="telefone" placeholder="Telefone" required="required"><br>
                    </fieldset>
                </form>
            </section>
            
            <footer>
                <h3>Desenvolvido por Alexandre Barbieri e Felipe Teixeira</h3>
            </footer>
        </article>
    </body>
</html>
