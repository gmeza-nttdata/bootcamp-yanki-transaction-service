package com.nttdata.bootcamp.yankitransactionservice.infrastructure.repository;

import com.nttdata.bootcamp.yankitransactionservice.application.repository.YankiTransactionRepository;
import com.nttdata.bootcamp.yankitransactionservice.domain.YankiTransactionStatement;
import com.nttdata.bootcamp.yankitransactionservice.infrastructure.model.dao.YankiTransactionStatementDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class YankiTransactionCrudRepository implements YankiTransactionRepository {

    @Autowired
    IYankiTransactionCrudRepository repository;


    @Override
    public Flux<YankiTransactionStatement> get() {
        return repository.findAll().map(this::mapFromDao);
    }

    @Override
    public Mono<YankiTransactionStatement> get(String id) {
        return repository.findById(id).map(this::mapFromDao);
    }

    @Override
    public Mono<YankiTransactionStatement> create(YankiTransactionStatement yanki) {
        return Mono.just(yanki)
                .map(this::mapToDao)
                .flatMap(repository::save)
                .map(this::mapFromDao);
    }

    @Override
    public Mono<YankiTransactionStatement> update(String id, YankiTransactionStatement yanki) {
        return Mono.just(yanki)
                .doOnNext(y -> y.setId(id))
                .map(this::mapToDao)
                .flatMap(repository::save)
                .map(this::mapFromDao);
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }

    private YankiTransactionStatement mapFromDao(YankiTransactionStatementDao dao) {
        YankiTransactionStatement yanki = new YankiTransactionStatement();
        BeanUtils.copyProperties(dao, yanki);
        return yanki;
    }

    private YankiTransactionStatementDao mapToDao(YankiTransactionStatement yanki) {
        YankiTransactionStatementDao dao = new YankiTransactionStatementDao();
        BeanUtils.copyProperties(yanki, dao);
        return dao;
    }
}
