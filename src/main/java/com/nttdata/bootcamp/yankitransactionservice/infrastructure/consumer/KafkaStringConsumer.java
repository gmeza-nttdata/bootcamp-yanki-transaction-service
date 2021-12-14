package com.nttdata.bootcamp.yankitransactionservice.infrastructure.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaStringConsumer {


    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "TOPIC-DEMO", groupId = "group_id")
    public void consume(String message) {
        log.info("Consuming Message: " + message);
    }

}
