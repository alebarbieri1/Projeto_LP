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

    private long codigo;
    private Usuario usuario;
    private double precoTotal;
    private Date data;
    private List<ItemPedido> itensPedido;

    public Pedido() {
    }

    public Pedido(int codigo, Usuario usuario, double precoTotal, Date data) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.precoTotal = precoTotal;
        this.data = data;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        return "Pedido{" + "codigo=" + codigo + ", usuario=" + usuario + ", precoTotal=" + precoTotal + ", data=" + data + '}';
    }
}
