package com.example.fourgeeks.controller.rest;

import com.example.fourgeeks.model.Usuario;
import com.example.fourgeeks.model.common.RepBase;
import com.example.fourgeeks.repository.impl.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioRestController {
    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
        if(repository.save(usuario) != null){
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<RepBase> update(@RequestBody Usuario usuario){
        return ResponseEntity.ok(new RepBase(repository.update(usuario)));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable int id){
        return ResponseEntity.ok(repository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RepBase> delete(@PathVariable int id){
        return ResponseEntity.ok(new RepBase(repository.deleteByUsuarioId(id)));
    }

}
