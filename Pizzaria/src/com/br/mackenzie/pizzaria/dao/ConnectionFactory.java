/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.mackenzie.pizzaria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe Teixeira
 */
public class ConnectionFactory {

    private static ConnectionFactory instance;
    private Connection connection;
    private final String db = "pizzaria;useUnicode=yes&characterEncoding=UTF-8";
    private final String username = "mack";
    private final String password = "123";
    private final String protocol = "jdbc:derby://";
    private final String host = "localhost:1527/";
    private final String driver = "org.apache.derby.jdbc.ClientDriver";
    

    private ConnectionFactory() {
        try {
            Class.forName(driver).newInstance();
            connection = DriverManager.getConnection(protocol + host + db, username, password);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ConnectionFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnectio() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
