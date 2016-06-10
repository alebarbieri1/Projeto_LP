package br.mackenzie.fci.ec.lp2.controller.action;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Inmetrics
 */
public interface Action {

    public String execute(HttpServletRequest request, HttpServletResponse response, Method method) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
