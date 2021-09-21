package com.scott.reserved.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BaseRepository<T, K> extends MongoRepository<T, K> {
}
