package com.scott.reserved.service;

import com.scott.reserved.model.Client;
import com.scott.reserved.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends CrudService<Client, String> {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    public void configureGenericService() {
        setBaseRepository(clientRepository);
    }
}
