package com.kosinov.ping_pong.queues;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kosinov.ping_pong.model.Pong;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
public class PongProducer {
    private static final String PONG_OUT_BINDING_NAME = "pong-out-0";

    private final StreamBridge streamBridge;

    private final ObjectMapper objectMapper;

    public PongProducer(StreamBridge streamBridge, ObjectMapper objectMapper) {
        this.streamBridge = streamBridge;
        this.objectMapper = objectMapper;
    }

    public void sendPong(Pong pong) throws JsonProcessingException {
        streamBridge.send(PONG_OUT_BINDING_NAME, objectMapper.writeValueAsString(pong));
    }
}
