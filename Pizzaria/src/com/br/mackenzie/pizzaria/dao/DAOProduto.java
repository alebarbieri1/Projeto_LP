/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.mackenzie.pizzaria.dao;

import com.br.mackenzie.pizzaria.model.Produto;
import com.br.mackenzie.pizzaria.model.Sabor;
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
 * @author Alexandre Lopes
 */
public class DAOProduto implements GenericDAO<Produto> {

    private final Connection connection;

    public DAOProduto() {
        connection = ConnectionFactory.getInstance().getConnection();
    }

    /**
     *
     * @param p
     * @return
     */
    @Override
    public long create(Produto p) {
        long resultado = -1;
        String sql = "INSERT INTO produto(codigo_sabor, nome, preco) VALUES(?,?,?)";
        try (PreparedStatement pst = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pst.setLong(1, p.getSabor().getCodigo());
            pst.setString(2, p.getNome());
            pst.setDouble(3, p.getPreco());
            int linhasAfetadas = pst.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                if (rs != null && rs.next()) {
                    resultado = rs.getLong(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public List read() {
        List<Produto> produtos = new ArrayList();
        try {
            String sql = "SELECT * FROM produto";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs != null && rs.next()) {
                int codigo = rs.getInt("codigo");
                int codigo_sabor = rs.getInt("codigo_sabor");
                // Buscar o objeto sabor através do código acima
                Sabor sabor = null;
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");

                Produto produto = new Produto();
                produto.setCodigo(codigo);
                produto.setSabor(sabor);
                produto.setNome(nome);
                produto.setPreco(preco);
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return produtos;
    }

    @Override
    public Produto readById(long codigo) {
        Produto produto = null;
        String sql = "SELECT * FROM cliente WHERE id = ?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setLong(1, codigo);
            ResultSet rst = st.executeQuery();

            long codigo_sabor = rst.getInt("codigo_sabor");
            // Buscar o objeto sabor através do código acima
            Sabor sabor = null;
            String nome = rst.getString("nome");
            double preco = rst.getDouble("preco");

            while (rst.next()) {
                produto = new Produto();
                produto.setCodigo(codigo);
                produto.setSabor(sabor);
                produto.setNome(nome);
                produto.setPreco(preco);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }

    @Override
    public boolean delete(Produto e) {
        boolean apagou = false;
        String sql = "DELETE from produto WHERE codigo = ?";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setLong(1, e.getCodigo());
            int resultado = pst.executeUpdate();
            if (resultado > 0) {
                apagou = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return apagou;
    }

    @Override
    public boolean update(Produto e) {
        
        boolean atualizou = false;
        String sql = "UPDATE produto SET codigo_sabor = ?, nome = ?, preco = ? WHERE codigo = ?";
        try (PreparedStatement pst = connection.prepareStatement(sql)){
            pst.setLong(1, e.getSabor().getCodigo());
            pst.setString(2, e.getNome());
            pst.setDouble(3, e.getPreco());
            pst.setLong(4, e.getCodigo());
            int resultado = pst.executeUpdate();

            if (resultado > 0) {
                atualizou = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return atualizou;
    }
}