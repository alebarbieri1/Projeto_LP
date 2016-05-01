/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.mackenzie.pizzaria.dao;

import com.br.mackenzie.pizzaria.model.javabeans.Usuario;
import com.br.mackenzie.pizzaria.model.javabeans.UsuarioInfo;
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
        // String sql = "INSERT INTO usuario (codigo_usuario, codigo_usuarioinfo, nome_usuario, senha, tipo_usuario) VALUES (?,?,?,?,?)";
        try (PreparedStatement pst = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, e.getNomeUsuario());
            pst.setString(2, e.getSenha());
            pst.setInt(3, e.getTipoUsuario());
            pst.setLong(4, e.getUsuarioInfo().getCpf());

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
        List<Usuario> usuarios = new ArrayList();
        String sql = "SELECT * FROM usuario";
        try(PreparedStatement pst = connection.prepareStatement(sql)){
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                long codigo_usuario = rs.getLong("codigo_usuario");
                String nome_usuario = rs.getString("nome_usuario");
                String senha = rs.getString("senha");
                Integer tipo_usuario = rs.getInt("tipo_usuario");
                long codigo_usuarioinfo = rs.getLong("codigo_usuarioinfo");
                
                Usuario u = new Usuario();
                
                u.setCodigo_usuario(codigo_usuario);
                u.setNomeUsuario(nome_usuario);
                u.setSenha(senha);
                u.setTipoUsuario(tipo_usuario);
                u.setUsuarioInfo(new DAOUsuarioInfo().readById(codigo_usuarioinfo));
                
                usuarios.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    @Override
    public Usuario readById(long id) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuario WHERE codigo_usuario = ?";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();

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

        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;
    }

    // Para o login
    public Usuario readByName(String name) {
        String sql = "SELECT * FROM usuario WHERE nome_usuario = ?";
        Usuario usuario = null;
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                long codigo_usuario = rs.getLong("codigo_usuario");
                long codigo_usuarioinfo = rs.getLong("codigo_usuarioinfo");
                UsuarioInfo usuario_info = new DAOUsuarioInfo().readById(codigo_usuarioinfo);
                String nome_usuario = rs.getString("nome_usuario");
                String senha = rs.getString("senha");
                Integer tipo_usuario = rs.getInt("tipo_usuario");

                usuario = new Usuario();
                usuario.setCodigo_usuario(codigo_usuario);
                usuario.setNomeUsuario(nome_usuario);
                usuario.setSenha(senha);
                usuario.setTipoUsuario(tipo_usuario);
                usuario.setUsuarioInfo(usuario_info);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    @Override
    public boolean delete(Usuario e) {
        boolean apagou = false;
        String sql = "DELETE FROM usuario WHERE codigo_usuario = ?";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setLong(1, e.getCodigo_usuario());

            int resultado = pst.executeUpdate();

            if (resultado > 0) {
                apagou = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return apagou;
    }

    @Override
    public boolean update(Usuario e) {
        boolean atualizou = false;
        String sql = "UPDATE usuario SET nome_usuario = ?,"
                + " senha = ?, tipo_usuario = ?, codigo_usuarioinfo = ? WHERE codigo_usuario = ?";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, e.getNomeUsuario());
            pst.setString(2, e.getSenha());
            pst.setInt(3, e.getTipoUsuario());
            pst.setLong(4, e.getUsuarioInfo().getCpf());
            pst.setLong(5, e.getCodigo_usuario());

            int resultado = pst.executeUpdate();

            if (resultado > 0) {
                atualizou = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return atualizou;
    }

}
