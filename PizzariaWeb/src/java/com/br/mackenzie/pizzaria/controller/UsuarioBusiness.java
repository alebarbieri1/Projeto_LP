/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.mackenzie.pizzaria.controller;

import com.br.mackenzie.pizzaria.dao.DAOUsuario;
import com.br.mackenzie.pizzaria.dao.DAOUsuarioInfo;
import com.br.mackenzie.pizzaria.model.javabeans.Usuario;
import com.br.mackenzie.pizzaria.model.javabeans.UsuarioInfo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexandre Lopes
 */
@WebServlet(name = "UsuarioBusiness", urlPatterns = {"/UsuarioBusiness"})
public class UsuarioBusiness extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String command = request.getParameter("command");

            if (command.endsWith("login")) {

                String usuario = request.getParameter("usuario");
                String senha = request.getParameter("senha");

                DAOUsuario dao_usuario = new DAOUsuario();
                Usuario u = dao_usuario.readByName(usuario);

                if (u == null) {
                    request.getSession().setAttribute("msgErro", "Usuário não encontrado!");
                    //out.println("Usuario não encontrado");
                    response.sendRedirect("erro.jsp");
                } else if (u.getSenha().equals(senha)) {
                    request.getSession().setAttribute("usuario", u);
                    response.sendRedirect("home.jsp");
                } else {
                    request.getSession().setAttribute("msgErro", "Senha Incorreta!");
                    response.sendRedirect("erro.jsp");
                }
            } else if (command.endsWith("logout")) {
                // Remove todas as variáveis da sessão
                request.getSession().invalidate();
                response.sendRedirect("index.jsp");

            } else if (command.endsWith("cadastrar")) {
                
                UsuarioInfo usuarioInfo = new UsuarioInfo();
                usuarioInfo.setCep(request.getParameter("cep"));
                usuarioInfo.setCpf(Long.parseLong(request.getParameter("cpf")));
                usuarioInfo.setEndereco(request.getParameter("endereco"));
                usuarioInfo.setNome(request.getParameter("nome"));
                usuarioInfo.setTelefone(request.getParameter("telefone"));
                Usuario u = new Usuario();
                u.setNomeUsuario(request.getParameter("nome_usuario"));
                u.setSenha(request.getParameter("senha"));
                u.setTipoUsuario(1);
                u.setUsuarioInfo(usuarioInfo);

                DAOUsuario daoUsuario = new DAOUsuario();
                DAOUsuarioInfo daoInfo = new DAOUsuarioInfo();
                u.setCodigo_usuario(daoUsuario.create(u));
                usuarioInfo.setUsuario(u);
                daoInfo.create(usuarioInfo);

                Usuario usuarioAutenticado = daoUsuario.readByName(u.getNomeUsuario());
                request.getSession().setAttribute("usuario", usuarioAutenticado);
                response.sendRedirect("home.jsp");

            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
