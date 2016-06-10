/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.mackenzie.pizzaria.model.dao;

import com.br.mackenzie.pizzaria.model.javabeans.ItemPedido;
import com.br.mackenzie.pizzaria.model.javabeans.Pedido;
import com.br.mackenzie.pizzaria.model.javabeans.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe Teixeira
 */
public class DAOPedido implements GenericDAO<Pedido> {

    private final Connection connection;

    public DAOPedido() {
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public long create(Pedido e) {
        long resultado = -1;

        // Arrumar na tabela do banco - usuario ao invés de cliente
        String sql = "INSERT INTO pedido (cliente, preco_total, data) VALUES (?,?,?)";

        try {
            PreparedStatement pst = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            pst.setLong(1, e.getUsuario().getCodigo_usuario());
            pst.setDouble(2, e.getPrecoTotal());
            pst.setDate(3, new java.sql.Date(e.getData().getTime()));

            int linhasAfetadas = pst.executeUpdate();

            if (linhasAfetadas > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                if (rs != null && rs.next()) {
                    resultado = rs.getLong(1);
                    System.out.println(resultado);
                    e.setCodigo(resultado);

                    sql = "INSERT INTO item_pedido(cod_pedido, cod_produto, quantidade, total_item) VALUES(?,?,?,?)";
                    PreparedStatement pst2 = connection.prepareStatement(sql);

                    for (ItemPedido i : e.getItensPedido()) {
                        pst2.setLong(1, e.getCodigo());
                        pst2.setLong(2, i.getProduto().getCodigo());
                        pst2.setLong(3, i.getQuantidade());
                        pst2.setDouble(4, i.getTotal());

                        pst2.executeUpdate();
                    }
                    pst2.close();
                }
            }
            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(DAOPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public List<Pedido> read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pedido readById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Pedido> readByUsuarioId(long id) {
        List<Pedido> listaP = new ArrayList();
        Usuario u = new DAOUsuario().readById(id);
        try {
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM pedido WHERE cliente = ?");
            pst.setLong(1, id);
            
            ResultSet rs= pst.executeQuery();
                  
            while(rs.next()){
            Pedido p = new Pedido();
            p.setCodigo(rs.getLong("codigo"));
            p.setData(rs.getDate("data"));
            p.setPrecoTotal(rs.getDouble("preco"));
            p.setUsuario(u);
            List<ItemPedido> listaItem = new ArrayList();
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(DAOPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaP;
    }

    @Override
    public boolean delete(Pedido e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Pedido e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
