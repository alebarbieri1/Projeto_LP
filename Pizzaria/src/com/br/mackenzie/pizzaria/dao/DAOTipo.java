/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.mackenzie.pizzaria.dao;

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
public class DAOTipo implements GenericDAO<Tipo> {

    private static Connection connection;

    public DAOTipo() {
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public long create(Tipo e) {
        long resultado = -1;
        String sql = "INSERT INTO tipo (nome) VALUES (?)";
        try (PreparedStatement pst = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, e.getNome());
            int linhasAfetadas = pst.executeUpdate();

            if (linhasAfetadas > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                if (rs != null && rs.next()) {
                    resultado = rs.getLong(1);
                }
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOTipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public List<Tipo> read() {
        List<Tipo> tipos = new ArrayList();
        String sql = "SELECT * FROM tipo";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Tipo tipo = new Tipo();
                long codigo = rs.getLong("codigo");
                String nome = rs.getString("nome");
                tipo.setCodigo(codigo);
                tipo.setNome(nome);

                tipos.add(tipo);

            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOTipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tipos;
    }

    @Override
    public Tipo readById(long id) {
        Tipo tipo = null;
        String sql = "SELECT * FROM tipo WHERE codigo = ?";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                long codigo = rs.getLong("codigo");
                String nome = rs.getString("nome");
                tipo = new Tipo();
                tipo.setCodigo(codigo);
                tipo.setNome(nome);
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOTipo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tipo;
    }

    @Override
    public boolean delete(Tipo e) {
        boolean apagou = false;
        String sql = "DELETE FROM tipo WHERE codigo = ?";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setLong(1, e.getCodigo());
            int resultado = pst.executeUpdate();
            if (resultado > 0) {
                apagou = true;
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOTipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return apagou;
    }

    @Override
    public boolean update(Tipo e) {
        boolean atualizou = false;
        String sql = "UPDATE tipo SET nome = ? WHERE codigo = ?";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, e.getNome());
            pst.setLong(2, e.getCodigo());
            int resultado = pst.executeUpdate();

            if (resultado > 0) {
                atualizou = true;
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOTipo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return atualizou;
    }

}
