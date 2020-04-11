package com.example.newspaper.controller.rest;

import com.example.newspaper.model.Seccion;
import com.example.newspaper.model.common.RepBase;
import com.example.newspaper.repository.impl.SeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/seccion")
public class SeccionRestController {

    @Autowired
    private SeccionRepository seccionRepository;

    @PostMapping//(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RepBase> save(@RequestBody @Valid Seccion seccion){
        return ResponseEntity.ok(new RepBase(seccionRepository.save(seccion)));
    }

    @PutMapping
    public ResponseEntity<RepBase> update(@RequestBody @Valid Seccion seccion){
        return ResponseEntity.ok(new RepBase(seccionRepository.update(seccion)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RepBase> delete(@PathVariable int id){
        return ResponseEntity.ok(new RepBase(seccionRepository.deleteById(id)));
    }

    @GetMapping
    public ResponseEntity<List<Seccion>> findAll(){
        return ResponseEntity.ok(seccionRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seccion> findById(@PathVariable int id){
        return ResponseEntity.ok(seccionRepository.findById(id));
    }
}
