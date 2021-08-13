package ru.dementev.grpcserverdemo.service;

import ru.dementev.grpcserverdemo.entity.Client;
import ru.dementev.grpcserverdemo.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public void save(Client client) {
        if (Objects.isNull(client)) {
            throw new NullPointerException();
        }
        clientRepository.save(client);
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public Client remove(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        clientRepository.deleteById(id);
        return client;
    }

}
