package com.nttdata.bootcamp.yankitransactionservice.infrastructure.rest;

import com.nttdata.bootcamp.yankitransactionservice.application.YankiTransactionOperations;
import com.nttdata.bootcamp.yankitransactionservice.domain.YankiTransactionStatement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/yanki-transactions")
@RequiredArgsConstructor
public class YankiTransactionController {

    private final YankiTransactionOperations operations;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Flux<YankiTransactionStatement>>> get() {
        return Mono.just(ResponseEntity.ok(operations.get()));
    }

}
