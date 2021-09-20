package com.scott.reserved.repository;

import com.scott.reserved.model.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends BaseRepository<Client, String> {
}
