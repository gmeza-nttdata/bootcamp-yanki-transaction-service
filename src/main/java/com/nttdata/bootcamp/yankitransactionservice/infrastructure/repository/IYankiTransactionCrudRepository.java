package com.nttdata.bootcamp.yankitransactionservice.infrastructure.repository;

import com.nttdata.bootcamp.yankitransactionservice.domain.YankiTransactionStatement;
import com.nttdata.bootcamp.yankitransactionservice.infrastructure.model.dao.YankiTransactionStatementDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IYankiTransactionCrudRepository extends ReactiveCrudRepository<YankiTransactionStatementDao, String> {
}
