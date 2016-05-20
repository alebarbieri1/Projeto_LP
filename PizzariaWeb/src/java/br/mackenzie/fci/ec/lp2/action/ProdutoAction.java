/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.action;

import com.br.mackenzie.pizzaria.dao.DAOProduto;
import com.br.mackenzie.pizzaria.dao.DAOSabor;
import com.br.mackenzie.pizzaria.model.javabeans.Produto;
import com.br.mackenzie.pizzaria.model.javabeans.Sabor;

/**
 *
 * @author Felipe Teixeira
 */
public class ProdutoAction extends ActionSupport {

    // Insere no banco
    public String cadastrar() {
        String nome = this.getRequest().getParameter("nome");
        long sabor = Long.parseLong(this.getRequest().getParameter("sabor"));
        double preco = Double.parseDouble(this.getRequest().getParameter("preco"));
        
        Sabor s = new Sabor();
        s.setCodigo(sabor);
        
        Produto p = new Produto();
        p.setNome(nome);
        p.setPreco(preco);
        p.setSabor(s);
        
        DAOProduto produtodao = new DAOProduto();
        produtodao.create(p);
        
        this.getRequest().setAttribute("produtos", produtodao.read());
        return "WEB-INF/jsp/produto/listarProduto.jsp";
    }
    
    // Redireciona para a tela de cadastro
    public String novo(){
        this.getRequest().setAttribute("sabores", new DAOSabor().read());
        return "WEB-INF/jsp/produto/cadastrarProduto.jsp";
    }

    public String remover() {
        long codigo = Long.parseLong(this.getRequest().getParameter("codigo"));
        Produto p = new Produto();
        p.setCodigo(codigo);
        DAOProduto produtodao = new DAOProduto();
        produtodao.delete(p);
        this.getRequest().setAttribute("produtos", produtodao.read());
        return "WEB-INF/jsp/produto/listarProduto.jsp";
    }

    // Edita no banco
    public String editar() {
        long codigo = Long.parseLong(this.getRequest().getParameter("codigo"));
        String nome = this.getRequest().getParameter("nome");
        Long codigo_sabor = Long.parseLong(this.getRequest().getParameter("codigo_sabor"));
        Double preco = Double.parseDouble(this.getRequest().getParameter("preco"));
        
        Sabor s = new DAOSabor().readById(codigo_sabor);
        
        Produto p = new Produto();
        p.setCodigo(codigo);
        p.setNome(nome);
        p.setSabor(s);
        p.setPreco(preco);
        
        DAOProduto produtodao = new DAOProduto();
        produtodao.update(p);
        
        this.getRequest().setAttribute("produtos", produtodao.read());
        return "WEB-INF/jsp/produto/listarProduto.jsp";
    }
    
    // Redireciona para a página de alteração
    public String alterar(){
        Long codigo = Long.parseLong(this.getRequest().getParameter("codigo"));
        Produto p = new DAOProduto().readById(codigo);
        this.getRequest().setAttribute("produto", p);
        return "WEB-INF/jsp/produto/alterarProduto.jsp";
    }
    
    public String listar(){
        this.getRequest().setAttribute("produtos", new DAOProduto().read());
        return "WEB-INF/jsp/produto/listarProduto.jsp";
    }
}
