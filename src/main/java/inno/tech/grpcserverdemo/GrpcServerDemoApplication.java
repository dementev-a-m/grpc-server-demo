package inno.tech.grpcserverdemo;

import io.grpc.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class GrpcServerDemoApplication implements CommandLineRunner {

    private final Server server;

    public static void main(String[] args) {
        SpringApplication.run(GrpcServerDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        server.start();
        server.awaitTermination();
    }
}
