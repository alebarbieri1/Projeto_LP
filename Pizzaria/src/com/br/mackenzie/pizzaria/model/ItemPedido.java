/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.mackenzie.pizzaria.model;

/**
 *
 * @author Felipe Teixeira
 */
public class ItemPedido {

    private Produto produto;
    private int quantidade;
    private double total;

    public ItemPedido() {
    }

    public ItemPedido(Produto produto, int quantidade, double total) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.total = total;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
