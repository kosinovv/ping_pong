package com.kosinov.ping_pong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PingPongApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.kosinov.ping_pong.PingPongApplication.class, args);
    }

}
