package com.example.fourgeeks.controller.rest;

import com.example.fourgeeks.model.Grupo;
import com.example.fourgeeks.model.common.RepBase;
import com.example.fourgeeks.repository.impl.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Grupo> delete(@PathVariable int id){
        if (repository.deleteById(id)){
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
