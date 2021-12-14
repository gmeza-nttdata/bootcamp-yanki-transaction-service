package com.nttdata.bootcamp.yankitransactionservice.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class YankiTransactionStatement {
    private String id;
    private Long yankiId;
    private OperationType operation;
    private BigDecimal amount;
    private LocalDateTime dateTime;
    private BigDecimal fee;

    public YankiTransactionStatement() {}

    public YankiTransactionStatement(Long yankiId, OperationType operation, BigDecimal amount, BigDecimal fee ) {
        this.yankiId = yankiId;
        this.operation = operation;
        this.amount = amount;
        this.fee = fee;
    }

    public YankiTransactionStatement(Long yankiId, OperationType operation, BigDecimal amount) {
        this(yankiId, operation, amount, BigDecimal.ZERO);
    }

}
