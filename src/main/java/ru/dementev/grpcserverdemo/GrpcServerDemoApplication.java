package ru.dementev.grpcserverdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class GrpcServerDemoApplication  {

    public static void main(String[] args) {
        SpringApplication.run(GrpcServerDemoApplication.class, args);
    }
}
