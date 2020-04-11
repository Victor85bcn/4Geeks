package com.example.newspaper.controller.rest;

import com.example.newspaper.model.Categoria;
import com.example.newspaper.repository.impl.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Categoria> save(@RequestBody @Valid Categoria categoria){
        return ResponseEntity.ok(categoriaRepository.save(categoria));
    }

    @PutMapping
    public ResponseEntity<Categoria> update(@RequestBody @Valid Categoria categoria){
        return ResponseEntity.ok(categoriaRepository.update(categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Categoria> delete(@PathVariable int id){
        if (categoriaRepository.deleteById(id)){
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(){
        return ResponseEntity.ok(categoriaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable int id){
        Categoria categoria = categoriaRepository.findById(id);
        if ( categoria != null){
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
