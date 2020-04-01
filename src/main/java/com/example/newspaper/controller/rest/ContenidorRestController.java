package com.example.newspaper.controller.rest;

import com.example.newspaper.model.Contenido;
import com.example.newspaper.model.common.RepBase;
import com.example.newspaper.repository.ContenidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contenido")
public class ContenidorRestController {
    @Autowired
    private ContenidoRepository repository;

    @PostMapping
    public ResponseEntity<RepBase> save(@RequestBody Contenido contenido){
        return ResponseEntity.ok(new RepBase(repository.save(contenido)));
    }

    @PutMapping
    public ResponseEntity<RepBase> update(@RequestBody Contenido contenido){
        return ResponseEntity.ok(new RepBase(repository.update(contenido)));
    }

    @GetMapping
    public ResponseEntity<List<Contenido>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contenido> findById(@PathVariable int id){
        return ResponseEntity.ok(repository.findById(id));
    }
}
