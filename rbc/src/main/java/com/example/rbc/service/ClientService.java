package com.example.rbc.service;

import com.example.rbc.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAll();
    Client getById(Long id);
    void save(Client client);
    void delete(Long id);
}
