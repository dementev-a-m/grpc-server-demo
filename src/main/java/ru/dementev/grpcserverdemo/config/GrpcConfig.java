package ru.dementev.grpcserverdemo.config;


import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.NettyServerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.List;

@Configuration
public class GrpcConfig {

    @Bean
    public Server server(List<BindableService> servers) throws IOException, InterruptedException {
        ServerBuilder<?> serverBuilder = NettyServerBuilder.forPort(8080);
        servers.forEach(serverBuilder::addService);
        Server server = serverBuilder.build();
        server.start();
        Runtime.getRuntime().addShutdownHook(new Thread(server::shutdown));
        return server;
    }

}
