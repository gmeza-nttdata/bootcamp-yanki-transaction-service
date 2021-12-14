package com.nttdata.bootcamp.yankitransactionservice.application.impl;

import com.nttdata.bootcamp.yankitransactionservice.application.YankiTransactionOperations;
import com.nttdata.bootcamp.yankitransactionservice.application.repository.YankiTransactionRepository;
import com.nttdata.bootcamp.yankitransactionservice.domain.YankiTransactionStatement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
        return null;
    }
}
