package com.example.fourgeeks.controller.rest;

import com.example.fourgeeks.model.PostSeccion;
import com.example.fourgeeks.model.common.RepBase;
import com.example.fourgeeks.repository.impl.PostSeccionRepository;
import com.example.fourgeeks.service.PostSeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/postseccion")
public class PostSeccionRestController {
    @Autowired
    private PostSeccionRepository repository;

    @Autowired
    private PostSeccionService service;

    @PostMapping
    public ResponseEntity<RepBase> save(@RequestBody PostSeccion postSeccion){
        return ResponseEntity.ok(new RepBase(service.updatePostSeccion(postSeccion)));
    }

    @PutMapping
    public ResponseEntity<RepBase> update(@RequestBody PostSeccion postSeccion){
        return ResponseEntity.ok(new RepBase(service.updatePostSeccion(postSeccion)));
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
    public ResponseEntity<List<PostSeccion>> findBySeccionId(@PathVariable int id){
        return ResponseEntity.ok(repository.findBySeccionId(id));
    }
}
