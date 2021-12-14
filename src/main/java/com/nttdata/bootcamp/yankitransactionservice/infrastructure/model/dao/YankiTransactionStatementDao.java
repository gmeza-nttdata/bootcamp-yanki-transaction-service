package com.nttdata.bootcamp.yankitransactionservice.infrastructure.model.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document("YankiTransaction")
public class YankiTransactionStatementDao {
    @Id
    private String id;
    private String yankiId;
    private String operation;
    private BigDecimal amount;
    private LocalDateTime dateTime;
    private BigDecimal fee;
}
