/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.mackenzie.pizzaria.dao;

import com.br.mackenzie.pizzaria.model.javabeans.Cliente;
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
public class DAOCliente implements GenericDAO<Cliente> {

    private final Connection connection;

    public DAOCliente() {
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public long create(Cliente e) {
        long resultado = -1;

        try {
            String sql = "INSERT INTO cliente(cpf, nome, telefone, endereco) VALUES(?,?,?,?)";
            try (PreparedStatement pst = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                pst.setLong(1, e.getCpf());
                pst.setString(2, e.getNome());
                pst.setString(3, e.getTelefone());
                pst.setString(4, e.getEndereco());
                int linhasAfetadas = pst.executeUpdate();

                if (linhasAfetadas > 0) {
                    ResultSet rs = pst.getGeneratedKeys();
                    if (rs != null && rs.next()) {
                        resultado = rs.getLong(1);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public List<Cliente> read() {
        List<Cliente> clientes = new ArrayList();
        try {
            String sql = "SELECT * FROM cliente";

            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs != null && rs.next()) {
                String nome = rs.getString("nome");
                Long cpf = rs.getLong("cpf");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");

                Cliente c = new Cliente();
                c.setCpf(cpf);
                c.setEndereco(endereco);
                c.setTelefone(telefone);
                c.setNome(nome);
                clientes.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clientes;

    }

    @Override
    public Cliente readById(long cpf) {

        Cliente cliente = null;
        String sql = "SELECT * FROM cliente WHERE cpf = ?";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setLong(1, cpf);

            ResultSet rst = pst.executeQuery();

            while (rst != null && rst.next()) {
                cliente = new Cliente();
                cliente.setCpf(cpf);
                cliente.setNome(rst.getString("nome"));
                cliente.setEndereco(rst.getString("endereco"));
                cliente.setTelefone(rst.getString("telefone"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cliente;

    }

    @Override
    public boolean delete(Cliente e) {

        boolean apagou = false;
        String sql = "DELETE FROM cliente WHERE cpf= ?";
       
        try (PreparedStatement pst = connection.prepareStatement(sql)){
            pst.setLong(1, e.getCpf());

            int resultado = pst.executeUpdate();
            if (resultado > 0) {
                apagou = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return apagou;
    }

    @Override
    public boolean update(Cliente e) {

        boolean atualizou = false;

        String sql = "UPDATE cliente SET nome = ?, telefone = ?, endereco = ? WHERE cpf = ?";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, e.getNome());
            pst.setString(2, e.getTelefone());
            pst.setString(3, e.getEndereco());
            pst.setLong(4, e.getCpf());
            int resultado = pst.executeUpdate();

            if (resultado > 0) {
                atualizou = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return atualizou;

    }

}
