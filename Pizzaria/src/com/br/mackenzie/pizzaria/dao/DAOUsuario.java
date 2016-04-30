/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.mackenzie.pizzaria.dao;

import com.br.mackenzie.pizzaria.model.javabeans.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexandre Lopes
 */
public class DAOUsuario implements GenericDAO<Usuario> {

    private static Connection connection;

    public DAOUsuario() {
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public long create(Usuario e) {
        long resultado = -1;
        // String sql = "INSERT INTO usuario (codigo_usuario, codigo_usuarioinfo, nome_usuario, senha, tipo_usuario) VALUES (?,?,?,?,?)";
        String sql = "INSERT INTO usuario (nome_usuario, senha, tipo_usuario) VALUES (?,?,?)";
        try (PreparedStatement pst = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            // pst.setLong(1, e.getCodigo_usuario());
            //pst.setLong(2, e.getUsuarioInfo().getCpf());
            pst.setString(1, e.getNomeUsuario());
            pst.setString(2, e.getSenha());
            pst.setInt(3, e.getTipoUsuario());

            int linhasAfetadas = pst.executeUpdate();

            if (linhasAfetadas > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                if (rs != null && rs.next()) {
                    resultado = rs.getLong(1);
                }
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public List<Usuario> read() {
        return null;
    }

    @Override
    public Usuario readById(long id) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuario WHERE codigo_usuario = ?";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                long codigo_usuario = rs.getLong("codigo_usuario");
                long codigo_usuarioinfo = rs.getLong("codigo_usuarioinfo");
                String nome_usuario = rs.getString("nome_usuario");
                String senha = rs.getString("senha");
                Integer tipo_usuario = rs.getInt("tipoUsuario");

                usuario = new Usuario();
                usuario.setCodigo_usuario(codigo_usuario);
                usuario.setNomeUsuario(nome_usuario);
                usuario.setSenha(senha);
                usuario.setTipoUsuario(tipo_usuario);
                // usuario.setUsuarioInfo(null);
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;
    }

    @Override
    public boolean delete(Usuario e) {
        return false;
    }

    @Override
    public boolean update(Usuario e) {
        return false;
    }

}
