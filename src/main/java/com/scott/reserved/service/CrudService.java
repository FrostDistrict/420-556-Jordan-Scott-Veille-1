package com.scott.reserved.service;

import com.scott.reserved.model.BaseEntity;
import com.scott.reserved.repository.BaseRepository;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;

public class CrudService<T extends BaseEntity, K extends String> {

    private BaseRepository<T, K> baseRepository;

    public void setBaseRepository(BaseRepository<T, K> baseRepository) {
        this.baseRepository = baseRepository;
    }

    public Optional<T> create(T t) throws ValidationException {
        if (t != null) {
            return Optional.of(baseRepository.save(t));
        }
        return Optional.empty();
    }

    public Optional<T> getOneByID(K k) {
        if (k != null && baseRepository.existsById(k)) {
            return baseRepository.findById(k);
        }
        return Optional.empty();
    }

    public List<T> getAll() {
        return baseRepository.findAll();
    }

    public Optional<T> update(T t, K k) throws ValidationException {
        if (k != null && baseRepository.existsById(k) && t != null) {
            t.setId(k);
            return Optional.of(baseRepository.save(t));
        }
        return Optional.empty();
    }

    public boolean deleteByID(K k) {
        if (k != null && baseRepository.existsById(k)) {
            baseRepository.deleteById(k);
            return true;
        }
        return false;
    }
}
