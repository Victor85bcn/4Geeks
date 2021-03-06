package com.example.fourgeeks.controller.rest;

import com.example.fourgeeks.model.Comentario;
import com.example.fourgeeks.model.common.RepBase;
import com.example.fourgeeks.repository.impl.ComentarioRepository;
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
        if(repository.findById(id) != null){
            return ResponseEntity.ok(repository.findById(id));
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<List<Comentario>> findByPostId(@PathVariable int id){
        if(repository.findByPostId(id) != null){
            return ResponseEntity.ok(repository.findByPostId(id));
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RepBase> delete(@PathVariable int id){
        return ResponseEntity.ok(new RepBase(repository.deleteById(id)));
    }
}
