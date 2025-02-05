package com.hospital.common.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService<T, ID> {
    T save(T entity);
    Optional<T> findById(ID id);
    Page<T> findAll(Pageable pageable);
    void deleteById(ID id);
}
