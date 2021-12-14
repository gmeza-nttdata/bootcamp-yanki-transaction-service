package com.nttdata.bootcamp.yankitransactionservice.application.impl;

import com.nttdata.bootcamp.yankitransactionservice.application.YankiTransactionOperations;
import com.nttdata.bootcamp.yankitransactionservice.application.repository.YankiTransactionRepository;
import com.nttdata.bootcamp.yankitransactionservice.domain.OperationType;
import com.nttdata.bootcamp.yankitransactionservice.domain.YankiTransactionStatement;
import com.nttdata.bootcamp.yankitransactionservice.infrastructure.producer.KafkaStringProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.math.BigDecimal;

@Slf4j
@Service
@RequiredArgsConstructor
public class YankiTransactionOperationsImpl implements YankiTransactionOperations {

    private final YankiTransactionRepository repository;

    @Override
    public Flux<YankiTransactionStatement> get() {
        return repository.get();
    }

    @Override
    public Mono<YankiTransactionStatement> send(Long source, Long target, BigDecimal amount) {
        return Mono.zip(
                Mono.just(new YankiTransactionStatement(source, OperationType.SENT, amount))
                    .map(repository::create),
                Mono.just(new YankiTransactionStatement(target, OperationType.RECEIVED, amount))
                    .map(repository::create)
        )
                .flatMap(Tuple2::getT1);
    }
}
