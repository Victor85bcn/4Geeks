package com.example.newspaper.controller.rest;

import com.example.newspaper.model.Usuario;
import com.example.newspaper.model.common.RepBase;
import com.example.newspaper.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioRestController {
    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public ResponseEntity<RepBase> save(@RequestBody Usuario usuario){
        return ResponseEntity.ok(new RepBase(repository.save(usuario)));
    }

    @PutMapping
    public ResponseEntity<RepBase> update(@RequestBody Usuario usuario){
        return ResponseEntity.ok(new RepBase(repository.update(usuario)));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(SpringDataWebProperties.Pageable pageable){
        return ResponseEntity.ok(repository.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable int id){
        return ResponseEntity.ok(repository.findById(id));
    }
}
