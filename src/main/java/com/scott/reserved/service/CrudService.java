package com.scott.reserved.service;

import com.scott.reserved.model.BaseEntity;
import com.scott.reserved.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;

public class CrudService<T extends BaseEntity, K extends String> {

    private BaseRepository<T, String>   baseRepository;

    @Autowired
    public void setBaseRepository(BaseRepository<T, String> baseRepository) {
        this.baseRepository = baseRepository;
    }

    public Optional<T> create(T t) throws ValidationException {
        if (t != null) {
            return Optional.of(baseRepository.save(t));
        }
        return Optional.empty();
    }

    public Optional<T> getOneByID(String ID) {
        if (ID != null && baseRepository.existsById(ID)) {
            return baseRepository.findById(ID);
        }
        return Optional.empty();
    }

    public List<T> getAll() {
        return baseRepository.findAll();
    }

    public Optional<T> update(T t, String ID) throws ValidationException {
        if (ID != null && baseRepository.existsById(ID) && t != null) {
            t.setId(ID);
            return Optional.of(baseRepository.save(t));
        }
        return Optional.empty();
    }

    public boolean deleteByID(String ID) {
        if (ID != null && baseRepository.existsById(ID)) {
            baseRepository.deleteById(ID);
            return true;
        }
        return false;
    }
}
