/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.frontcontroller;

import br.mackenzie.fci.ec.lp2.action.Action;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Inmetrics
 */
@WebServlet("*.action")
public class Controller extends HttpServlet {

    private static final String SEPARADOR = "!";
    private final ResourceBundle actionMap = ResourceBundle.
            getBundle("br.mackenzie.fci.ec.lp2.util.actionConfig");

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
        String result;
        try {
            Class actionClass = Class.forName(actionMap.getString(getActionName(request)));
            Method actionMethod = getRealMethod(request, actionClass);
            Object actionInstanciada = actionClass.newInstance();
            
            if (!(actionInstanciada instanceof Action)) {
                throw new ServletException("Classe informada não é uma classe de ação!");
            }
            Action action = (Action) actionInstanciada;
            result = action.execute(request, response, actionMethod);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServletException(ex);
        }
        request.getRequestDispatcher(result).forward(request, response);
    }

    private String getActionName(HttpServletRequest request) {
        return request.getRequestURI().replace(request.getContextPath() + "/", "").replace(".action", "").split(SEPARADOR)[0];
    }

    private String getMethodName(HttpServletRequest request) {
        return request.getRequestURI().replace(request.getContextPath() + "/", "").replace(".action", "").split(SEPARADOR)[1];
    }

    private Method getRealMethod(HttpServletRequest request, Class actionClass) {
        Method method = null;

        try {
            method = actionClass.getMethod(getMethodName(request), new Class[0]);
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            if (actionClass != Object.class) {
                method = getRealMethod(request, actionClass.getSuperclass());
            }
        }
        return method;
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
