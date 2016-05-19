/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.action;

import com.br.mackenzie.pizzaria.dao.DAOSabor;
import com.br.mackenzie.pizzaria.dao.DAOTipo;
import com.br.mackenzie.pizzaria.model.javabeans.Sabor;
import com.br.mackenzie.pizzaria.model.javabeans.Tipo;

/**
 *
 * @author Felipe Teixeira
 */
public class SaborAction extends ActionSupport {

    // Insere no banco
    public String cadastrar() {
        String nome = this.getRequest().getParameter("nome");
        String tipo = this.getRequest().getParameter("tipo");
        String descricao = this.getRequest().getParameter("descricao");
        int codigo = Integer.parseInt(tipo);
        Tipo t = new Tipo();
        t.setCodigo(codigo);
        Sabor s = new Sabor();
        s.setTipo(t);
        s.setDescricao(descricao);
        s.setNome(nome);
        DAOSabor sabordao = new DAOSabor();
        sabordao.create(s);
        this.getRequest().setAttribute("sabores", sabordao.read());
        return "WEB-INF/jsp/sabor/listarSabor.jsp";
    }
    
    // Redireciona para a tela de cadastro
    public String novo(){
        this.getRequest().setAttribute("tipos", new DAOTipo().read());
        return "WEB-INF/jsp/sabor/cadastrarSabor.jsp";
    }

    public String remover() {
        long codigo = Long.parseLong(this.getRequest().getParameter("codigo"));
        Sabor s = new Sabor();
        s.setCodigo(codigo);
        DAOSabor sabordao = new DAOSabor();
        sabordao.delete(s);
        this.getRequest().setAttribute("sabores", sabordao.read());
        return "WEB-INF/jsp/sabor/listarSabor.jsp";
    }

    // Edita no banco
    public String editar() {
        long codigo = Long.parseLong(this.getRequest().getParameter("codigo"));
        String nome = this.getRequest().getParameter("nome");
        String descricao = this.getRequest().getParameter("descricao");
        Long codigo_tipo = Long.parseLong(this.getRequest().getParameter("codigo_tipo"));
        Tipo tipo = new DAOTipo().readById(codigo_tipo);
        Sabor s = new Sabor();
        s.setCodigo(codigo);
        s.setNome(nome);
        s.setDescricao(descricao);
        s.setTipo(tipo);
        DAOSabor sabordao = new DAOSabor();
        sabordao.update(s);
        this.getRequest().setAttribute("sabores", sabordao.read());
        return "WEB-INF/jsp/sabor/listarSabor.jsp";
    }
    
    // Redireciona para a página de alteração
    public String alterar(){
        Long codigo = Long.parseLong(this.getRequest().getParameter("codigo"));
        Sabor sabor = new DAOSabor().readById(codigo);
        sabor.setCodigo(codigo);
       
        this.getRequest().setAttribute("sabor", sabor);
        return "WEB-INF/jsp/sabor/alterarSabor.jsp";
    }
    
    public String listar(){
        this.getRequest().setAttribute("sabores", new DAOSabor().read());
        return "WEB-INF/jsp/sabor/listarSabor.jsp";
    }
}
