/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.mackenzie.pizzaria.dao;

import java.util.List;

/**
 *
 * @author Felipe Teixeira
 * @param <E>
 */
public interface GenericDAO<E> {

    public long create(E e);

    public List<E> read();

    public E readById(long id);

    public boolean delete(E e);

    public boolean update(E e);
}
