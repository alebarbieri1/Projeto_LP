/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaria;

import com.br.mackenzie.pizzaria.dao.DAOPedido;
import com.br.mackenzie.pizzaria.dao.DAOProduto;
import com.br.mackenzie.pizzaria.dao.DAOSabor;
import com.br.mackenzie.pizzaria.dao.DAOTipo;
import com.br.mackenzie.pizzaria.dao.DAOUsuario;
import com.br.mackenzie.pizzaria.dao.DAOUsuarioInfo;
import com.br.mackenzie.pizzaria.model.javabeans.ItemPedido;
import com.br.mackenzie.pizzaria.model.javabeans.Pedido;
import com.br.mackenzie.pizzaria.model.javabeans.Produto;
import com.br.mackenzie.pizzaria.model.javabeans.Sabor;
import com.br.mackenzie.pizzaria.model.javabeans.Tipo;
import com.br.mackenzie.pizzaria.model.javabeans.Usuario;
import com.br.mackenzie.pizzaria.model.javabeans.UsuarioInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alexandre Lopes e Felipe Teixeira
 */
public class Pizzaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tipo t = new Tipo();
        t.setCodigo(3);
        DAOTipo dt = new DAOTipo();
        Sabor s = new Sabor();
        s.setCodigo(1);
        DAOSabor ds = new DAOSabor();
        s = ds.readById(s.getCodigo());
        System.out.println(s.getNome());

        Produto p = new Produto();
        p.setNome("Pizza Meia1");
        p.setSabor(s);
        p.setPreco(12.40);
        DAOProduto dp = new DAOProduto();
        p.setCodigo(dp.create(p));

        for (Produto p1 : dp.read()) {
            System.out.println(p1.getNome());
        }
        p.setNome("Outro");
        dp.update(p);
        for (Produto p1 : dp.read()) {
            System.out.println(p1.getNome());
        }

        ItemPedido ip = new ItemPedido();
        ip.setQuantidade(5);
        ip.setTotal(5 * p.getPreco());
        ip.setProduto(p);

        ItemPedido ip2 = new ItemPedido();
        ip2.setQuantidade(10);
        ip2.setTotal(10 * p.getPreco());
        ip2.setProduto(p);

        Pedido pedido = new Pedido();
        pedido.setData(new Date());
        pedido.setPrecoTotal(555);

        List<ItemPedido> itens = new ArrayList();
        itens.add(ip);
        itens.add(ip2);
        pedido.setItensPedido(itens);
        
        Usuario u = new Usuario();
        u.setCodigo_usuario(1);
        DAOPedido dp2 = new DAOPedido();
        pedido.setUsuario(u);
        pedido.setCodigo(dp2.create(pedido));
    }

}
