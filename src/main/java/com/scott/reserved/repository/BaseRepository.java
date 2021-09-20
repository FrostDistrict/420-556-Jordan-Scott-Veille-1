package com.scott.reserved.repository;

import com.scott.reserved.model.BaseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BaseRepository extends MongoRepository<BaseEntity, Long> {
}
