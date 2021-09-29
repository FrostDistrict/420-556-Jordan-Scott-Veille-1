package com.scott.reserved.controller;

import com.scott.reserved.model.Client;
import com.scott.reserved.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/client")
public class ClientController extends GenericController<Client, String> {

    @Autowired
    private ClientService clientService;

    @Autowired
    public void configureGenericController() {
        setCrudService(clientService);
    }
}
