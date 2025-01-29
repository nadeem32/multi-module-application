package com.las.moduler.application.basemodule.baseentity;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;

import java.util.stream.Collectors;

public abstract class GenericService<T extends BaseEntity, DTO, ID> {

    @Autowired
    private GenericRepository<T, ID> repository;

    @Autowired
    private ModelMapper modelMapper;

    private final Class<T> entityClass;
    private final Class<DTO> dtoClass;

    protected GenericService(Class<T> entityClass, Class<DTO> dtoClass) {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    public List<DTO> findAll() {
        return repository.findAll().stream()
                .map(entity -> modelMapper.map(entity, dtoClass))
                .collect(Collectors.toList());
    }

    public Optional<DTO> findById(ID id) {
        return repository.findById(id)
                .map(entity -> modelMapper.map(entity, dtoClass));
    }

    public DTO save(DTO dto) {
        T entity = modelMapper.map(dto, entityClass);
        T savedEntity = repository.save(entity);
        return modelMapper.map(savedEntity, dtoClass);
    }

    public void delete(ID id) {
        repository.deleteById(id);
    }
}


//public abstract class GenericService<T, ID> {
//    @Autowired
//    private BaseRepository<T, ID> repository;
//
//    public List<T> findAll() {
//        return repository.findAll();
//    }
//
//    public Optional<T> findById(ID id) {
//        return repository.findById(id);
//    }
//
//    public T save(T entity) {
//        return repository.save(entity);
//    }
//
//    public void delete(ID id) {
//        repository.deleteById(id);
//    }
//}