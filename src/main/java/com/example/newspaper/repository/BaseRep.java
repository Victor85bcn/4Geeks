package com.example.newspaper.repository;

import java.awt.print.Pageable;
import java.util.List;

public interface BaseRep<T> {

    public boolean save(T object);
    public boolean update(T object);
    public List<T> findAll(Pageable pageable);
    public T findById(int id);
}
