package inno.tech.grpcserverdemo.server;

import inno.tech.grpcserverdemo.Client;
import inno.tech.grpcserverdemo.ClientServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
@Slf4j
@Component
public class ClientServerImpl extends ClientServiceGrpc.ClientServiceImplBase implements GrpcServer {

    public void getClient(Client.ClientRequest request, StreamObserver<Client.ClientResponse> responseObserver) {
        log.info("Пришел запрос "+ request);
        Client.ClientResponse response = Client.ClientResponse.newBuilder()
                .setClientId(request.getClientId())
                .setFirstName("Игорь")
                .setLastName("Кушнир")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
