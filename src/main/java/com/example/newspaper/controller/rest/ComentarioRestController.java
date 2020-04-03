package com.example.newspaper.controller.rest;

import com.example.newspaper.model.Comentario;
import com.example.newspaper.model.common.RepBase;
import com.example.newspaper.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comentario")
public class ComentarioRestController {
    @Autowired
    private ComentarioRepository repository;

    @PostMapping
    public ResponseEntity<RepBase> save(@RequestBody Comentario comentario){
        return ResponseEntity.ok(new RepBase(repository.save(comentario)));
    }

    @PutMapping
    public ResponseEntity<RepBase> update(@RequestBody Comentario comentario){
        return ResponseEntity.ok(new RepBase(repository.update(comentario)));
    }

    @GetMapping
    public ResponseEntity<List<Comentario>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comentario> findById(@PathVariable int id){
        return ResponseEntity.ok(repository.findById(id));
    }
}
