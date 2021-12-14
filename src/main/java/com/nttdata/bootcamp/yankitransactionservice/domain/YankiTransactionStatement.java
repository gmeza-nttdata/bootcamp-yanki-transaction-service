package com.nttdata.bootcamp.yankitransactionservice.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class YankiTransactionStatement {
    private String id;
    private String yankiId;
    private OperationType operation;
    private BigDecimal amount;
    private LocalDateTime dateTime;
    private BigDecimal fee;
}
