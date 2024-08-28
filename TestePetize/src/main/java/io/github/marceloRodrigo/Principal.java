package io.github.marceloRodrigo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class Principal {

    public static void main(String[] args){
        SpringApplication.run(Principal.class, args);
    }
}
