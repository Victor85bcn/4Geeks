package com.example.newspaper.controller.rest;

import com.example.newspaper.model.PostSeccion;
import com.example.newspaper.model.common.RepBase;
import com.example.newspaper.repository.impl.PostSeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/postseccion")
public class PostSeccionRestController {
    @Autowired
    private PostSeccionRepository repository;

    @PostMapping
    public ResponseEntity<RepBase> save(@RequestBody PostSeccion postSeccion){
        return ResponseEntity.ok(new RepBase(repository.save(postSeccion)));
    }

    @PutMapping
    public ResponseEntity<RepBase> update(@RequestBody PostSeccion postSeccion){
        return ResponseEntity.ok(new RepBase(repository.update(postSeccion)));
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<RepBase> delete(@PathVariable int id){
        return ResponseEntity.ok(new RepBase(repository.deleteByPostId(id)));
    }

    @GetMapping
    public ResponseEntity<List<PostSeccion>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<PostSeccion> findByPostId(@PathVariable int id){
        return ResponseEntity.ok(repository.findByPostId(id));
    }

    @GetMapping("/seccion/{id}")
    public ResponseEntity<PostSeccion> findBySeccionId(@PathVariable int id){
        return ResponseEntity.ok(repository.findBySeccionId(id));
    }
}
