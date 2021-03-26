package inno.tech.grpcserverdemo.config;

import inno.tech.grpcserverdemo.server.ClientServerImpl;
import inno.tech.grpcserverdemo.server.GrpcServer;
import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GrpcConfig {

    @Bean
    public Server server(List<GrpcServer> servers) {
        ServerBuilder<?> serverBuilder = ServerBuilder.forPort(8080);
        servers.forEach(grpcServer -> serverBuilder.addService((BindableService) grpcServer));
        return serverBuilder.build();
    }

}
