/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.controller.action;

import com.br.mackenzie.pizzaria.model.dao.DAOPedido;
import com.br.mackenzie.pizzaria.model.dao.DAOProduto;
import com.br.mackenzie.pizzaria.model.dao.DAOUsuario;
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
        String usuario = this.getRequest().getParameter("usuario");
        
        if (usuario == null || usuario.equals("")){
            this.getRequest().setAttribute("msgErro", "Você precisa estar logado para efetuar um pedido!");
            return "erro.jsp";
        }
        if (produtos==null){
            this.getRequest().setAttribute("msgErro", "Selecione ao menos uma pizza!");
            return "erro.jsp";
        }
        
        long codigoU = Long.parseLong(usuario);
        Pedido p = new Pedido();
        p.setData(new Date());
        p.setUsuario(new DAOUsuario().readById(codigoU));
        
        List<ItemPedido> ls = new ArrayList();
        DAOProduto daop = new DAOProduto();
        for (String s : produtos) {
            long codigo = Long.parseLong(s);
            ItemPedido ip = new ItemPedido();
            ip.setProduto(daop.readById(codigo));
            String qtd = this.getRequest().getParameter("qtd_" + s);
            ip.setQuantidade(Integer.parseInt(qtd));
            ip.setTotal(ip.getProduto().getPreco() * ip.getQuantidade());
            ls.add(ip);
        }
        p.setItensPedido(ls);
        p.setPrecoTotal();
        DAOPedido daope = new DAOPedido();
        long codigoPedido = daope.create(p);
        p.setCodigo(codigoPedido);
        this.getRequest().setAttribute("pedido", p);
        
        
        return "WEB-INF/jsp/pedido/listarPedido.jsp";
    }
 
}
