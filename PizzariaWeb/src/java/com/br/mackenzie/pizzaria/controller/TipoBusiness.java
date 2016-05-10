/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.mackenzie.pizzaria.controller;

import com.br.mackenzie.pizzaria.dao.DAOTipo;
import com.br.mackenzie.pizzaria.model.javabeans.Tipo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 31584381
 */
@WebServlet(name = "TipoBusiness", urlPatterns = {"/TipoBusiness"})
public class TipoBusiness extends HttpServlet {

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
            if (command.endsWith("cadastrar")) {
                String nome = request.getParameter("nome");
                Tipo t = new Tipo();
                t.setNome(nome);
                DAOTipo tipodao = new DAOTipo();
                tipodao.create(t);
                RequestDispatcher rd = request.getRequestDispatcher("listarTipo.jsp");
                request.setAttribute("tipos", tipodao.read());
                rd.forward(request, response);
                
            } else if (command.endsWith("remover")) {
                long codigo = Long.parseLong(request.getParameter("codigo"));
                Tipo t = new Tipo();
                t.setCodigo(codigo);
                DAOTipo tipodao = new DAOTipo();
                tipodao.delete(t);
                RequestDispatcher rd = request.getRequestDispatcher("listarTipo.jsp");
                request.setAttribute("tipos", tipodao.read());
                rd.forward(request, response);
                
            } else if (command.endsWith("alterar")) {
                
                RequestDispatcher rd = request.getRequestDispatcher("alterarTipo.jsp");
                request.setAttribute("codigo", request.getParameter("codigo"));
                rd.forward(request, response);

            } else if(command.endsWith("editar")){
                long codigo = Long.parseLong(request.getParameter("codigo"));
                String nome = request.getParameter("nome");
                Tipo t = new Tipo();
                t.setCodigo(codigo);
                t.setNome(nome);
                DAOTipo tipodao = new DAOTipo();
                tipodao.update(t);
                
                RequestDispatcher rd = request.getRequestDispatcher("listarTipo.jsp");
                request.setAttribute("tipos", tipodao.read());
                rd.forward(request, response);
            } 
            else if (command.endsWith("listar")){
                request.setAttribute("tipos", new DAOTipo().read());
                RequestDispatcher rd = request.getRequestDispatcher("listarTipo.jsp");
                rd.forward(request, response);
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
