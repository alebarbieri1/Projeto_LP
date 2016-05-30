/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.action;

import com.br.mackenzie.pizzaria.dao.DAOProduto;
import com.br.mackenzie.pizzaria.dao.DAOSabor;
import com.br.mackenzie.pizzaria.dao.DAOTipo;
import com.br.mackenzie.pizzaria.model.javabeans.Produto;
import com.br.mackenzie.pizzaria.model.javabeans.Sabor;
import com.br.mackenzie.pizzaria.model.javabeans.Tipo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Inmetrics
 */
public class PizzaAction extends ActionSupport {
    
    public String listar(){
        DAOTipo dao_tipo = new DAOTipo();
        // Objeto Tipo com nome = Pizza (apenas um)
        Tipo tipo_pizza = dao_tipo.readByName("Pizza");
        DAOSabor dao_sabor = new DAOSabor();
        // Lista de sabores que possuem como tipo uma Pizza
        List<Sabor> sabores_pizza = dao_sabor.readByTipo(tipo_pizza);
        DAOProduto dao_produto = new DAOProduto();
        // Produtos que possuem como sabor uma Pizza
        List<Produto> produtos_pizza = new ArrayList();
        for (Sabor sabor_pizza : sabores_pizza){
            // Adiciona na lista de produtos, um produto que possui um sabor de pizza
            Produto produto = dao_produto.readBySabor(sabor_pizza);
            if (produto != null){
                produtos_pizza.add(produto);
            }   
        }
        this.getRequest().setAttribute("produtos", produtos_pizza);
        this.getRequest().setAttribute("usuario", this.getRequest().getSession().getAttribute("usuario"));
        return "WEB-INF/jsp/pizza/listarPizza.jsp";
    }
    
}
