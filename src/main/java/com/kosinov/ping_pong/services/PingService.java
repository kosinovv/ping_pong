package com.kosinov.ping_pong.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kosinov.ping_pong.model.Ping;
import com.kosinov.ping_pong.queues.PingProducer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class PingService {

    private final PingProducer pingProducer;

    private int pingCount = 0;

    public PingService(PingProducer pingProducer) {
        this.pingProducer = pingProducer;
    }

    @Scheduled(fixedDelay = 10000)
    public void sendPing() throws JsonProcessingException {
        pingCount = pingCount +1;
        Ping ping = new Ping(pingCount, LocalDateTime.now());
        pingProducer.sendPing(ping);
    }
}
