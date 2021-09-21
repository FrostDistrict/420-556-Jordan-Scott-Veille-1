package com.scott.reserved.controller;

import com.scott.reserved.dto.ResponseMessage;
import com.scott.reserved.model.BaseEntity;
import com.scott.reserved.service.CrudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public class GenericController<T extends BaseEntity, K extends String> {

    private CrudService<T, K> crudService;

    public void setCrudService(CrudService<T, K> service) {
        this.crudService = service;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody T t){
        Optional<T> optional = crudService.create(t);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }

        return ResponseEntity
                .badRequest()
                .body(new ResponseMessage("Error: body may not be null")) ;
    }

    @GetMapping("/get")
    public ResponseEntity<?> get(@Valid @RequestParam K id){
        if (id == null) {
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseMessage("Error: id may not be null"));
        }

        Optional<T> optional = crudService.getOneByID(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }

        return ResponseEntity
                .notFound()
                .build();
    }

    @GetMapping("/getAll")
    public List<T> getAll(){
        return crudService.getAll();
    }

    @PutMapping("/update{id}")
    public ResponseEntity<?> update(@RequestBody T t, @PathVariable K id){
        if (t == null || id == null) {
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseMessage("Error: request body may not be null"));
        }

        Optional<T> optional = crudService.update(t, id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }

        return ResponseEntity
                .notFound()
                .build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam K id){
        if (id == null) {
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseMessage("Error: id may not be null"));
        }

        if (crudService.deleteByID(id)) {
            return ResponseEntity.ok(new ResponseMessage("Delete successful"));
        }

        return ResponseEntity
                .notFound()
                .build();
    }
}
