package com.las.moduler.application.basemodule.baseentity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class GenericController<T extends BaseEntity, DTO, ID> {

    private final GenericService<T, DTO, ID> service;

    // Constructor to inject the service
    public GenericController(GenericService<T, DTO, ID> service) {
        this.service = service;
    }

    @GetMapping
    public List<DTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<DTO> getById(@PathVariable ID id) {
        return service.findById(id);
    }

    @PostMapping
    public DTO create(@RequestBody DTO dto) {
        return service.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id) {
        service.delete(id);
    }
}
//public abstract class GenericController<T, ID> {
//    private final GenericService<T, ID> service;
//
//    public GenericController(GenericService<T, ID> service) {
//        this.service = service;
//    }
//
//    @GetMapping
//    public List<T> getAll() {
//        return service.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Optional<T> getById(@PathVariable ID id) {
//        return service.findById(id);
//    }
//
//    @PostMapping
//    public T create(@RequestBody T entity) {
//        return service.save(entity);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable ID id) {
//        service.delete(id);
//    }
//}