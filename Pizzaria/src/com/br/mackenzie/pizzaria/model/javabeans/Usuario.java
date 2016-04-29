/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.mackenzie.pizzaria.model.javabeans;

/**
 *
 * @author Alexandre Lopes
 */
public abstract class Usuario {
    
    private long codigo_usuario;
    private String nomeUsuario;
    private String senha;
    private Integer tipoUsuario;
    private Usuario usuario;

    public Usuario() {
    }

    public Usuario(String usuario) {
        if (usuario.equals("funcionario")){
            this.usuario = new Funcionario();
        } else {
            this.usuario = new Cliente();
        }
    }
    
    public long getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(long codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Integer tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }  
}
