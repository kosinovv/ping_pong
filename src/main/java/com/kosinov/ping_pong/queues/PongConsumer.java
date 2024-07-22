package com.kosinov.ping_pong.queues;

import com.kosinov.ping_pong.model.Ping;
import org.apache.logging.log4j.message.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class PongConsumer {

    @Bean
    public Consumer<Ping> pingMsgConsumer() {
        return msg -> System.out.printf("Ping_id %s, Ping_date_time: %s\n", msg.getPing_id(), msg.getPing_date_time());
    }
}
