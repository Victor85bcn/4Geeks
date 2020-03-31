package com.example.newspaper.controller.rest;

import com.example.newspaper.model.PostMetadata;
import com.example.newspaper.model.common.RepBase;
import com.example.newspaper.repository.PostMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/postmetadata")
public class PostMetadataRestController {
    @Autowired
    private PostMetadataRepository repository;

    @PostMapping
    public ResponseEntity<RepBase> save(@RequestBody PostMetadata postMetadata){
        return ResponseEntity.ok(new RepBase(repository.save(postMetadata)));
    }

    @PutMapping
    public ResponseEntity<RepBase> update(@RequestBody PostMetadata postMetadata){
        return ResponseEntity.ok(new RepBase(repository.update(postMetadata)));
    }

    @GetMapping
    public ResponseEntity<List<PostMetadata>> findAll(SpringDataWebProperties.Pageable pageable){
        return ResponseEntity.ok(repository.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostMetadata> findById(@PathVariable int id){
        return ResponseEntity.ok(repository.findById(id));
    }
}
