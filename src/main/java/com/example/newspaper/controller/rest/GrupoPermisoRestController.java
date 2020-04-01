package com.example.newspaper.controller.rest;

import com.example.newspaper.model.GrupoPermiso;
import com.example.newspaper.model.common.RepBase;
import com.example.newspaper.repository.GrupoPermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/grupopermiso")
public class GrupoPermisoRestController {
    @Autowired
    private GrupoPermisoRepository repository;

    @PostMapping
    public ResponseEntity<RepBase> save(@RequestBody GrupoPermiso grupoPermiso){
        return ResponseEntity.ok(new RepBase(repository.save(grupoPermiso)));
    }

    @PutMapping
    public ResponseEntity<RepBase> update(@RequestBody GrupoPermiso grupoPermiso){
        return ResponseEntity.ok(new RepBase(repository.update(grupoPermiso)));
    }

    @GetMapping
    public ResponseEntity<List<GrupoPermiso>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrupoPermiso> findById(@PathVariable int id){
        return ResponseEntity.ok(repository.findById(id));
    }
}
