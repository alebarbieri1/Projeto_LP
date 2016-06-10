/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.mackenzie.pizzaria.model.dao;

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
        String sql = "INSERT INTO usuario (nome_usuario, senha, tipo_usuario) VALUES (?,?,?)";
        try (PreparedStatement pst = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
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
            // Atribui o código do usuário
            e.setCodigo_usuario(resultado);
            
            DAOUsuarioInfo daoUsuarioInfo = new DAOUsuarioInfo();
            daoUsuarioInfo.create(e.getUsuarioInfo());

        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public List<Usuario> read() {
        List<Usuario> lista = new ArrayList();

        String sql = "SELECT * FROM usuario";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                long codigo_usuario = rs.getLong("codigo_usuario");

                String nome_usuario = rs.getString("nome_usuario");
                String senha = rs.getString("senha");
                Integer tipo_usuario = rs.getInt("tipo_usuario");

                Usuario usuario = new Usuario();
                usuario.setCodigo_usuario(codigo_usuario);
                usuario.setNomeUsuario(nome_usuario);
                usuario.setSenha(senha);
                usuario.setTipoUsuario(tipo_usuario);
                // usuario.setUsuarioInfo(null);
                lista.add(usuario);
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
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
          
                String nome_usuario = rs.getString("nome_usuario");
                String senha = rs.getString("senha");
                Integer tipo_usuario = rs.getInt("tipo_usuario");

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

    public Usuario readByName(String name) {
        String sql = "SELECT * FROM usuario WHERE nome_usuario = ?";
        Usuario usuario = null;
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setCodigo_usuario(rs.getLong("codigo_usuario"));
                usuario.setNomeUsuario(rs.getString("nome_usuario"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipoUsuario(rs.getInt("tipo_usuario"));
                //UsuarioInfo usuario_info = new DAOUsuarioInfo().readById(rs.getLong("codigo_usuarioinfo"));
                //usuario.setUsuarioInfo(usuario_info);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;
    }

    @Override
    public boolean delete(Usuario e) {
        boolean retorno = false;
        String sql = "DELETE FROM usuario WHERE codigo_usuario=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setLong(1, e.getCodigo_usuario());
            int res = pst.executeUpdate();
            if (res > 0) {
                retorno = true;
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

    @Override
    public boolean update(Usuario e) {
        boolean retorno = false;
        String sql = "UPDATE usuario SET nome_usuario=?, senha=? WHERE codigo_usuario =?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, e.getNomeUsuario());
            pst.setString(2, e.getSenha());
            pst.setLong(3, e.getCodigo_usuario());

            int result = pst.executeUpdate();
            if (result > 0) {
                retorno = true;
            }
            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuarioInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

}
