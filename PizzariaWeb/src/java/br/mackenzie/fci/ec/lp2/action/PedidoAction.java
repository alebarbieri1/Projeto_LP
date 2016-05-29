/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.action;

import com.br.mackenzie.pizzaria.dao.DAOPedido;
import com.br.mackenzie.pizzaria.dao.DAOProduto;
import com.br.mackenzie.pizzaria.dao.DAOUsuario;
import com.br.mackenzie.pizzaria.model.javabeans.ItemPedido;
import com.br.mackenzie.pizzaria.model.javabeans.Pedido;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Felipe Teixeira
 */
public class PedidoAction extends ActionSupport {

    // Insere no banco
    public String finalizar() {
        String[] produtos = this.getRequest().getParameterValues("selecionados");
        String cliente = this.getRequest().getParameter("cliente");
        
        if(cliente==null|| cliente.equals("0")) return "Home.jsp";
        if(produtos==null) return "Home.jsp";
        
        long codigoC = Long.parseLong(cliente);
        Pedido p = new Pedido();
        p.setData(new Date());
        p.setUsuario(new DAOUsuario().readById(codigoC));
        
        List<ItemPedido> ls = new ArrayList();
        DAOProduto daop = new DAOProduto();
        for (String s : produtos) {
            long codigo = Long.parseLong(s);
            ItemPedido ip = new ItemPedido();
            ip.setProduto(daop.readById(codigo));
            ip.setQuantidade(1);
            ip.setTotal(ip.getProduto().getPreco());
            ls.add(ip);
        }
        p.setItensPedido(ls);
        p.setPrecoTotal();
        DAOPedido daope = new DAOPedido();
        daope.create(p);
        this.getRequest().setAttribute("pedidos", new DAOPedido().read());
        return "WEB-INF/jsp/pedido/listarPedidos.jsp";
    }
 
}
