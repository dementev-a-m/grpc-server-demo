package ru.dementev.grpcserverdemo.service;

import ru.dementev.grpcserverdemo.entity.Client;

public interface ClientService {
    void save(Client client);
    Client findById(Long id);
    Client remove(Long id);
}
