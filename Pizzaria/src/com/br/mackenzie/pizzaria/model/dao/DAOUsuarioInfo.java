/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.mackenzie.pizzaria.model.dao;

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
public class DAOUsuarioInfo implements GenericDAO<UsuarioInfo> {
    
    private static Connection connection;
    
    public DAOUsuarioInfo() {
        connection = ConnectionFactory.getInstance().getConnection();
    }
// UsuarioInfo (cpf, nome, telefone, endereco, cep, codigo_usuario)

    @Override
    public long create(UsuarioInfo e) {
        long resultado = -1;
        // String sql = "INSERT INTO usuario (codigo_usuario, codigo_usuarioinfo, nome_usuario, senha, tipo_usuario) VALUES (?,?,?,?,?)";
        String sql = "INSERT INTO usuario_info (cpf, nome, telefone, endereco, cep, codigo_usuario) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement pst = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pst.setLong(1, e.getCpf());
            pst.setString(2, e.getNome());
            pst.setString(3, e.getTelefone());
            pst.setString(4, e.getEndereco());
            pst.setString(5, e.getCep());
            pst.setLong(6, e.getUsuario().getCodigo_usuario());
            
            int linhasAfetadas = pst.executeUpdate();
            
            if (linhasAfetadas > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                if (rs != null && rs.next()) {
                    resultado = rs.getLong(1);
                }
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuarioInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    @Override
    public List<UsuarioInfo> read() {
        List<UsuarioInfo> lista = new ArrayList();
        String sql = "SELECT * FROM usuario_info";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {                
                
                UsuarioInfo u = new UsuarioInfo();
                u.setCep(rs.getString("cep"));
                u.setCpf(rs.getLong("cpf"));
                u.setEndereco(rs.getString("endereco"));
                u.setNome(rs.getString("nome"));
                u.setTelefone(rs.getString("telefone"));
                u.getUsuario().setCodigo_usuario(rs.getLong("codigo_usuario"));
                
                lista.add(u);
                
            }
            
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuarioInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    @Override
    public UsuarioInfo readById(long id) {
        UsuarioInfo usuario = null;
        String sql = "SELECT * FROM usuario_info WHERE codigo_usuario = ?";
        
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                long codigo_usuario = rs.getLong("codigo_usuario");
                long cpf = rs.getLong("cpf");
                String nome = rs.getString("nome");
                String telefone = rs.getString("telefone");
                String cep = rs.getString("cep");
                String endereco = rs.getString("endereco");
                // UsuarioInfo (cpf, nome, telefone, endereco, cep, codigo_usuario)

                usuario = new UsuarioInfo();
                usuario.setCep(cep);
                usuario.setCpf(cpf);
                usuario.setEndereco(endereco);
                usuario.setNome(nome);
                usuario.setTelefone(telefone);
                
            }
            
            pst.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuarioInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    @Override
    public boolean delete(UsuarioInfo e) {
        boolean retorno = false;
        String sql = "DELETE FROM usuario_info WHERE codigo_usuario=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setLong(1, e.getUsuario().getCodigo_usuario());
            
            int res = pst.executeUpdate();
            if (res > 0) {
                retorno = true;
            }
            
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuarioInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    @Override
    public boolean update(UsuarioInfo e) {
        // UsuarioInfo (cpf, nome, telefone, endereco, cep, codigo_usuario)
        boolean retorno = false;
        String sql = "UPDATE usuario_info SET cpf=?, nome=?, telefone=?, endereco=?, cep=? WHERE codigo_usuario =?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setLong(1, e.getCpf());
            pst.setString(2, e.getNome());
            pst.setString(3, e.getTelefone());
            pst.setString(4, e.getEndereco());
            pst.setString(5, e.getCep());
            pst.setLong(6, e.getUsuario().getCodigo_usuario());
            
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
