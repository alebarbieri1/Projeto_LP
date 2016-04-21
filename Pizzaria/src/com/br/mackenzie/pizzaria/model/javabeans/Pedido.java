/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.mackenzie.pizzaria.model.javabeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Felipe Teixeira
 */
public class Pedido implements Serializable {

    private int codigo;
    private Cliente cliente;
    private double precoTotal;
    private Date data;
    private List<ItemPedido> itensPedido;

    public Pedido() {
    }

    public Pedido(int codigo, Cliente cliente, double precoTotal, Date data) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.precoTotal = precoTotal;
        this.data = data;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" + "codigo=" + codigo + ", cliente=" + cliente + ", precoTotal=" + precoTotal + ", data=" + data + '}';
    }
}
