/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.mackenzie.pizzaria.dao;

import com.br.mackenzie.pizzaria.model.javabeans.ItemPedido;
import com.br.mackenzie.pizzaria.model.javabeans.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        String sql = "INSERT INTO pedido (usuario, preco_total, data) VALUES (?,?,?)";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setLong(1, e.getUsuario().getCodigo_usuario());
            pst.setDouble(2, e.getPrecoTotal());
            pst.setDate(3, new java.sql.Date(e.getData().getTime()));

            int linhasAfetadas = pst.executeUpdate();

            if (linhasAfetadas > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                if (rs != null && rs.next()) {
                    resultado = rs.getLong(1);

                    e.setCodigo(resultado);

                    sql = "INSERT INTO item_pedido(cod_pedido, cod_produto, quantidade, total_item) VALUES(?,?,?,?)";
                    pst = connection.prepareStatement(sql);

                    for (ItemPedido i : e.getItensPedido()) {
                        pst.setLong(1, e.getCodigo());
                        pst.setLong(2, i.getProduto().getCodigo());
                        pst.setLong(3, i.getQuantidade());
                        pst.setDouble(4, i.getTotal());

                        pst.executeUpdate();
                    }

                }
            }

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

    @Override
    public boolean delete(Pedido e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Pedido e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
