package ru.dementev.grpcserverdemo.converter;

import ru.dementev.grpcserverdemo.ClientOuterClass;
import ru.dementev.grpcserverdemo.entity.Client;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClientConverterService implements Converter<Client, ClientOuterClass.Client> {
    @Override
    public ClientOuterClass.Client convert(Client client) {
        return  ClientOuterClass.Client.newBuilder()
                .setClientId(client.getId())
                .setFirstName(client.getFirstName())
                .setLastName(client.getLastName())
                .setAge(client.getAge())
                .setPhoneNumber(client.getPhoneNumber())
                .build();
    }
}
