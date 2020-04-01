package com.example.newspaper.controller.rest;

import com.example.newspaper.model.Grupo;
import com.example.newspaper.model.common.RepBase;
import com.example.newspaper.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/grupo")
public class GrupoRestController {
    @Autowired
    private GrupoRepository repository;

    @PostMapping
    public ResponseEntity<RepBase> save(@RequestBody Grupo grupo){
        return ResponseEntity.ok(new RepBase(repository.save(grupo)));
    }

    @PutMapping
    public ResponseEntity<RepBase> update(@RequestBody Grupo grupo){
        return ResponseEntity.ok(new RepBase(repository.update(grupo)));
    }

    @GetMapping
    public ResponseEntity<List<Grupo>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grupo> findById(@PathVariable int id){
        return ResponseEntity.ok(repository.findById(id));
    }
}
