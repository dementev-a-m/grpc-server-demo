package ru.dementev.grpcserverdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("Client")
public class Client {
   @Id
   private Long id;
   private String firstName ;
   private String lastName ;
   private String phoneNumber ;
   private Integer age ;
}
