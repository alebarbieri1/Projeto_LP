<%-- 
    Document   : alterarSabor
    Created on : 17/05/2016, 09:57:13
    Author     : Inmetrics
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
        <%@include file="../../jspf/header.jspf" %>
        <article>
            <section id="cadastro">
                <form method="POST" action="${pageContext.request.contextPath}/sabor!editar.action">
                    <fieldset>
                        <legend>Alterar</legend>
                        <label>Alterar dados do sabor</label><br><br>
                        <label>Nome</label>
                        <input type="text" name="nome" placeholder="Nome" required="required" value="${sabor.nome}"><br>
                        <label>Descrição</label>
                        <input type="text" name="descricao" placeholder="Descrição" required="required" value="${sabor.descricao}"><br>
                        <input type="hidden" name="codigo" value="${sabor.codigo}"/>
                        <input type="hidden" name="codigo_tipo" value="${sabor.tipo.codigo}"/><br>
                        <input type="submit" value="Alterar">
                    </fieldset>
                </form>
            </section>
            <footer>
                Desenvolvido por Alexandre Barbieri e Felipe Teixeira
            </footer>
        </article>
    </body>
</html>
