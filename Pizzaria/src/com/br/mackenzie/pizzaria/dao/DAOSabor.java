/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.mackenzie.pizzaria.dao;

import com.br.mackenzie.pizzaria.model.javabeans.Sabor;
import com.br.mackenzie.pizzaria.model.javabeans.Tipo;
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
public class DAOSabor implements GenericDAO<Sabor> {

    private final Connection connection;

    public DAOSabor() {
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public long create(Sabor e) {

        long resultado = -1;
        String sql = "INSERT INTO sabor (codigo, cod_tipo, nome, descricao) VALUES (?,?,?,?)";

        try (PreparedStatement pst = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pst.setLong(1, e.getCodigo());
            pst.setLong(2, e.getTipo().getCodigo());
            pst.setString(3, e.getNome());
            pst.setString(4, e.getDescricao());
            int linhasAfetadas = pst.executeUpdate();

            if (linhasAfetadas > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                if (rs != null && rs.next()) {
                    resultado = rs.getLong(1);
                }
            }

            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOSabor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    @Override
    public List<Sabor> read() {
        List<Sabor> sabores = new ArrayList();
        String sql = "SELECT * FROM sabor";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Sabor sabor = new Sabor();
                long cod = rs.getLong("cod");
                long cod_tipo = rs.getLong("cod_tipo");
                Tipo tipo = new DAOTipo().readById(cod_tipo);
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                sabor.setCodigo(cod);
                sabor.setTipo(tipo);
                sabor.setNome(nome);
                sabor.setDescricao(descricao);

                sabores.add(sabor);
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOSabor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sabores;
    }

    @Override
    public Sabor readById(long id) {
        Sabor sabor = null;
        String sql = "SELECT * FROM sabor WHERE codigo = ?";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            long codigo = rs.getLong("codigo");
            long codigo_tipo = rs.getLong("cod_tipo");
            Tipo tipo = new DAOTipo().readById(codigo_tipo);
            String nome = rs.getString("nome");
            String descricao = rs.getString("descricao");
            sabor = new Sabor();
            sabor.setCodigo(codigo);
            sabor.setTipo(tipo);
            sabor.setNome(nome);
            sabor.setDescricao(descricao);

            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOSabor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sabor;
    }

    @Override
    public boolean delete(Sabor e) {
        boolean apagou = false;
        String sql = "DELETE FROM sabor WHERE codigo = ?";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setLong(1, e.getCodigo());
            int resultado = pst.executeUpdate();

            if (resultado > 0) {
                apagou = true;
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOSabor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return apagou;
    }

    @Override
    public boolean update(Sabor e) {
        boolean atualizou = false;
        String sql = "UPDATE sabor SET cod_tipo = ?, nome = ?, descricao = ? WHERE codigo = ?";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setLong(1, e.getTipo().getCodigo());
            pst.setString(2, e.getNome());
            pst.setString(3, e.getDescricao());
            pst.setLong(4, e.getCodigo());
            int resultado = pst.executeUpdate();

            if (resultado > 0) {
                atualizou = true;
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOSabor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return atualizou;
    }

}
