package com.scott.reserved.repository;

import com.scott.reserved.model.BaseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, K extends String> extends MongoRepository<T, K> {
}
