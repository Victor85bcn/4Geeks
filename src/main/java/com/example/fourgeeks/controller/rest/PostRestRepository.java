package com.example.fourgeeks.controller.rest;

import com.example.fourgeeks.model.Post;
import com.example.fourgeeks.model.common.RepBase;
import com.example.fourgeeks.repository.impl.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class PostRestRepository {

    @Autowired
    private PostRepository repository;

    @PostMapping
    public ResponseEntity<RepBase> save(@RequestBody Post post){
        return ResponseEntity.ok(new RepBase(repository.save(post)));
    }

    @PutMapping
    public ResponseEntity<RepBase> update(@RequestBody Post post){
        return ResponseEntity.ok(new RepBase(repository.update(post)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RepBase> delete(@PathVariable int id){
        return ResponseEntity.ok(new RepBase(repository.deleteByPostId(id)));
    }

    @GetMapping
    public ResponseEntity<List<Post>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable int id){
        return ResponseEntity.ok(repository.findById(id));
    }
}
