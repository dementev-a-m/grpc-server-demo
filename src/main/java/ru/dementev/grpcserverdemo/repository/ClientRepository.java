package ru.dementev.grpcserverdemo.repository;


import ru.dementev.grpcserverdemo.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
