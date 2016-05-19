/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.action;

import com.br.mackenzie.pizzaria.dao.DAOTipo;
import com.br.mackenzie.pizzaria.model.javabeans.Tipo;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Alexandre Lopes
 */
public class TipoAction extends ActionSupport {

    // Insere no banco
    public String cadastrar() {
        String nome = this.getRequest().getParameter("nome");
        Tipo t = new Tipo();
        t.setNome(nome);
        DAOTipo tipodao = new DAOTipo();
        tipodao.create(t);
        this.getRequest().setAttribute("tipos", tipodao.read());
        return "WEB-INF/jsp/tipo/listarTipo.jsp";
    }
    
    public String novo(){
        return "WEB-INF/jsp/tipo/cadastrarTipo.jsp";
    }

    public String remover() {
        long codigo = Long.parseLong(this.getRequest().getParameter("codigo"));
        Tipo t = new Tipo();
        t.setCodigo(codigo);
        DAOTipo tipodao = new DAOTipo();
        tipodao.delete(t);
        this.getRequest().setAttribute("tipos", tipodao.read());
        return "WEB-INF/jsp/tipo/listarTipo.jsp";
    }

    // Edita no banco
    public String editar() {
        long codigo = Long.parseLong(this.getRequest().getParameter("codigo"));
        String nome = this.getRequest().getParameter("nome");
        Tipo t = new Tipo();
        t.setCodigo(codigo);
        t.setNome(nome);
        DAOTipo tipodao = new DAOTipo();
        tipodao.update(t);
        this.getRequest().setAttribute("tipos", tipodao.read());
        return "WEB-INF/jsp/tipo/listarTipo.jsp";
    }
    
    // Redireciona para a página de alteração
    public String alterar(){
        Long codigo = Long.parseLong(this.getRequest().getParameter("codigo"));
        Tipo tipo = new DAOTipo().readById(codigo);
        this.getRequest().setAttribute("tipo", tipo);
        return "WEB-INF/jsp/tipo/alterarTipo.jsp";
    }
    
    public String listar(){
        this.getRequest().setAttribute("tipos", new DAOTipo().read());
        return "WEB-INF/jsp/tipo/listarTipo.jsp";
    }
}
