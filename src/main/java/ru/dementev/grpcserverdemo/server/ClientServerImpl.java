package ru.dementev.grpcserverdemo.server;


import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import ru.dementev.grpcserverdemo.ClientOuterClass;
import ru.dementev.grpcserverdemo.ClientServiceGrpc;
import ru.dementev.grpcserverdemo.entity.Client;
import ru.dementev.grpcserverdemo.service.ClientService;

@Slf4j
@RequiredArgsConstructor
@Component
public class ClientServerImpl extends ClientServiceGrpc.ClientServiceImplBase {

    private final ClientService clientService;
    private final ConversionService conversionService;

    @Override
    public void get(ClientOuterClass.ClientId request, StreamObserver<ClientOuterClass.Client> responseObserver) {
        log.info("Пришел запрос " + request);
        try {
            var client = clientService.findById(request.getClientId());
            var response = conversionService.convert(client, ClientOuterClass.Client.class);
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            responseObserver.onError(e);
        }
    }

    @Override
    public void save(ClientOuterClass.Client request, StreamObserver<Empty> responseObserver) {
        try {
            log.info("Пришел запрос " + request);
            var client = Client.builder()
                    .id(request.getClientId())
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .phoneNumber(request.getPhoneNumber())
                    .age(request.getAge())
                    .build();
            clientService.save(client);
            responseObserver.onNext(Empty.newBuilder().build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            responseObserver.onError(e);
        }

    }

    @Override
    public void remove(ClientOuterClass.ClientId request, StreamObserver<ClientOuterClass.Client> responseObserver) {
        try {
            var client = clientService.remove(request.getClientId());
            var response = conversionService.convert(client, ClientOuterClass.Client.class);
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            responseObserver.onError(e);
        }

    }

}
