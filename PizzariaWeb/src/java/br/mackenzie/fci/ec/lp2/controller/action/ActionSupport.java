/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.controller.action;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexandre Lopes
 */
public abstract class ActionSupport implements Action {
    
    private HttpServletRequest request;
    private HttpServletResponse response;
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, Method method) 
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        setRequest(request);
        setResponse(response);
        // Retorna o resultado do actionMethod, no caso, do método listar da classe CargoAction
        return (String) method.invoke(this, new Object[0]);
    }

    protected HttpServletRequest getRequest() {
        return request;
    }

    private void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    protected HttpServletResponse getResponse() {
        return response;
    }

    private void setResponse(HttpServletResponse response) {
        this.response = response;
    }
    
    
    
}
