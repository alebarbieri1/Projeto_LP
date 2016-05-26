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
public class Produto implements Serializable {

    private long codigo;
    private Sabor sabor;
    private String nome;
    private String descricao;
    private double preco;

    public Produto() {
    }

    public Produto(long codigo, Sabor sabor, String nome, double preco) {
        this.codigo = codigo;
        this.sabor = sabor;
        this.nome = nome;
        this.preco = preco;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Sabor getSabor() {
        return sabor;
    }

    public void setSabor(Sabor sabor) {
        this.sabor = sabor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", sabor=" + sabor + ", nome=" + nome + ", preco=" + preco + '}';
    }
}
