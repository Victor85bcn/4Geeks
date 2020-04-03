package com.example.newspaper.repository;

import java.util.List;

public interface BaseRep<T> {

    public boolean save(T object);
    public boolean update(T object);
    public List<T> findAll();
    public T findById(int id);
}
