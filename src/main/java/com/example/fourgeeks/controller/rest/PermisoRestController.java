package com.example.fourgeeks.controller.rest;

import com.example.fourgeeks.model.Permiso;
import com.example.fourgeeks.model.common.RepBase;
import com.example.fourgeeks.repository.impl.PermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/permiso")
public class PermisoRestController {

    @Autowired
    private PermisoRepository repository;

    @PostMapping
    public ResponseEntity<RepBase> save(@RequestBody Permiso permiso){
        return ResponseEntity.ok(new RepBase(repository.save(permiso)));
    }

    @PutMapping
    public ResponseEntity<RepBase> update(@RequestBody Permiso permiso){
        return ResponseEntity.ok(new RepBase(repository.update(permiso)));
    }

    @GetMapping
    public ResponseEntity<List<Permiso>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permiso> findById(@PathVariable int id){
        return ResponseEntity.ok(repository.findById(id));
    }
}

