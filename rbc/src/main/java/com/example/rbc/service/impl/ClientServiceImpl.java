package com.example.rbc.service.impl;

import com.example.rbc.model.Client;
import com.example.rbc.repository.ClientRepository;
import com.example.rbc.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client getById(Long id) {

        Client client = clientRepository.findById(id).orElse(null);

        if (client == null) {
            throw new RuntimeException("Did not find client id - " + id);
        }

        return client;
    }

    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
