package com.kosinov.ping_pong.queues;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kosinov.ping_pong.model.Ping;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
public class PingProducer {
    private static final String PING_OUT_BINDING_NAME = "ping-out-0";

    private final StreamBridge streamBridge;

    private final ObjectMapper objectMapper;

    public PingProducer(StreamBridge streamBridge, ObjectMapper objectMapper) {
        this.streamBridge = streamBridge;
        this.objectMapper = objectMapper;
    }

    public void sendPing(Ping ping) throws JsonProcessingException {
        streamBridge.send(PING_OUT_BINDING_NAME, objectMapper.writeValueAsString(ping));
    }
}
