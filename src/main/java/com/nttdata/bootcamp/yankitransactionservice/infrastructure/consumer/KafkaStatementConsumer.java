package com.nttdata.bootcamp.yankitransactionservice.infrastructure.consumer;

import com.nttdata.bootcamp.yankitransactionservice.application.repository.YankiTransactionRepository;
import com.nttdata.bootcamp.yankitransactionservice.domain.OperationType;
import com.nttdata.bootcamp.yankitransactionservice.domain.YankiTransactionStatement;
import com.nttdata.bootcamp.yankitransactionservice.infrastructure.model.dto.StatementDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.math.BigDecimal;

@Slf4j
@Component
public class KafkaStatementConsumer {

    @Autowired
    YankiTransactionRepository repository;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "TOPIC-DEMO", groupId = "group_id")
    public void consume(String message) {
        log.info("Consuming Message: " + message);
    }

    @KafkaListener(topics = "TOPIC-YANKI-STATEMENT", groupId = "group_id")
    public void createStatement(StatementDto message) {
        log.info("Consuming Message: " + message.toString());

        send(message.getSource(), message.getTarget(), message.getAmount())
                .doOnNext(s -> log.info(s.toString())).subscribe();
    }

    private Mono<Tuple2<Mono<YankiTransactionStatement>, Mono<YankiTransactionStatement>>> send(Long source, Long target, BigDecimal amount) {
        return Mono.zip(
                Mono.just(new YankiTransactionStatement(source, OperationType.SENT, amount))
                        .map(repository::create),
                Mono.just(new YankiTransactionStatement(target, OperationType.RECEIVED, amount))
                        .map(repository::create)
        );
    }

}
