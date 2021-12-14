package com.nttdata.bootcamp.yankitransactionservice.application;

import com.nttdata.bootcamp.yankitransactionservice.domain.YankiTransactionStatement;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public interface YankiTransactionOperations {

    Flux<YankiTransactionStatement> get();

    Mono<YankiTransactionStatement> send(Long source, Long target, BigDecimal amount);



}
