<%-- 
    Document   : home
    Created on : 04/05/2016, 15:20:34
    Author     : Alexandre Lopes
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pizzaria - Painel de Controle</title>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <c:if test="${usuario == null}">
            <div style="border-radius: 8px; color: #D63301; width: 90%; background-color: #FFCCBA; margin-top: 10px; padding: 5px; font-weight: bold;">É necessário estar logado e ser um administrador para ter acesso à esta página!</div>
        </c:if>
        <c:if test="${usuario != null}">
            <article>
            <h1>Painel de Controle</h1>
            <hr>
            <table style="width: 50%; margin-left: 25%;">
                <thead>
                    <tr>
                        <th>Gerenciar</th>
                        <th>Ação</th> 
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            Tipo
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/tipo!listar.action"><img src="${pageContext.request.contextPath}/imgs/iconeGerenciar.png" alt="Gerenciar" title="Gerenciar"/></a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Sabor
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/sabor!listar.action"><img src="${pageContext.request.contextPath}/imgs/iconeGerenciar.png" alt="Gerenciar" title="Gerenciar"/></a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Produto
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/produto!listar.action"><img src="${pageContext.request.contextPath}/imgs/iconeGerenciar.png" alt="Gerenciar" title="Gerenciar"/></a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </article>
        </c:if>
        <footer>
            Desenvolvido por Alexandre Barbieri e Felipe Teixeira
        </footer>
    </body>
</html>
