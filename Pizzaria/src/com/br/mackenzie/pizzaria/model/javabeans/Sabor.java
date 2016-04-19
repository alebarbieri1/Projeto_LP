/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.mackenzie.pizzaria.model.javabeans;

import java.io.Serializable;

/**
 *
 * @author Felipe Teixeira
 */
public class Sabor implements Serializable{

    private long codigo;
    private Tipo tipo;
    private String nome;
    private String descricao;
    
    public Sabor() {
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Sabor{" + "codigo=" + codigo + ", tipo=" + tipo + ", nome=" + nome + ", descricao=" + descricao + '}';
    }

}
