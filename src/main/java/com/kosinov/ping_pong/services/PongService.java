package com.kosinov.ping_pong.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kosinov.ping_pong.model.Ping;
import com.kosinov.ping_pong.model.Pong;
import com.kosinov.ping_pong.queues.PongProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.function.Consumer;

@Service
public class PongService {

    private final PongProducer pongProducer;

    private int pongCount = 0;

    public PongService(PongProducer pongProducer) {
        this.pongProducer = pongProducer;
    }

    public void sendPong() throws JsonProcessingException {
        pongCount = pongCount +1;
        Pong pong = new Pong(pongCount, LocalDateTime.now());
        pongProducer.sendPong(pong);
    }

    @Bean
    public Consumer<Ping> pingMsgConsumer() {
        return msg -> {
            System.out.printf("Ping_id %s, Ping_date_time: %s\n", msg.getPing_id(), msg.getPing_date_time());
            try {
                sendPong();
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
