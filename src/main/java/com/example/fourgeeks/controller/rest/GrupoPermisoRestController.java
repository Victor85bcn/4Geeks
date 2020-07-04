package com.example.fourgeeks.controller.rest;

import com.example.fourgeeks.model.GrupoPermiso;
import com.example.fourgeeks.model.common.RepBase;
import com.example.fourgeeks.repository.impl.GrupoPermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public ResponseEntity<List<GrupoPermiso>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrupoPermiso> findById(@PathVariable int id){
        return ResponseEntity.ok(repository.findById(id));
    }

    @DeleteMapping("/permiso/{permiso}")
    public ResponseEntity<RepBase> delete(@PathVariable int permiso){
        return ResponseEntity.ok(new RepBase(repository.deleteById(permiso)));
    }
}
