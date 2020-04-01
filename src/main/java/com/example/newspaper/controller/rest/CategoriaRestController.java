package com.example.newspaper.controller.rest;

import com.example.newspaper.model.Categoria;
import com.example.newspaper.model.common.RepBase;
import com.example.newspaper.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaRestController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping//(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RepBase> save(@RequestBody @Valid Categoria categoria){
        return ResponseEntity.ok(new RepBase(categoriaRepository.save(categoria)));
    }

    @PutMapping
    public ResponseEntity<RepBase> update(@RequestBody @Valid Categoria categoria){
        return ResponseEntity.ok(new RepBase(categoriaRepository.update(categoria)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RepBase> delete(@PathVariable int id){
        return ResponseEntity.ok(new RepBase(categoriaRepository.deleteById(id)));
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(){
        return ResponseEntity.ok(categoriaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable int id){
        return ResponseEntity.ok(categoriaRepository.findById(id));
    }
}
