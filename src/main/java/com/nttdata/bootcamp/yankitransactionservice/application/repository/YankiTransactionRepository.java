package com.nttdata.bootcamp.yankitransactionservice.application.repository;

import com.nttdata.bootcamp.yankitransactionservice.domain.YankiTransactionStatement;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface YankiTransactionRepository {
    Flux<YankiTransactionStatement> get();
    Mono<YankiTransactionStatement> get(String id);
    Mono<YankiTransactionStatement> create(YankiTransactionStatement yanki);
    Mono<YankiTransactionStatement> update(String id, YankiTransactionStatement yanki);
    Mono<Void> delete(String id);
}
