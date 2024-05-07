package com.omercan.transaction_app.model.service;

import java.util.List;

public interface EntityService<T , Integer>
{
    void deletedById(Integer ID);

    T findById(Integer ID);

    T save(T entity);

    List<T> findAll();



}
