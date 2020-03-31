package com.example.newspaper.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;

import java.util.List;

public interface BaseRep<T> {

    public boolean save(T object);
    public boolean update(T object);
    public List<T> findAll(SpringDataWebProperties.Pageable pageable);
    public T findById(int id);
}
