package com.nttdata.bootcamp.yankitransactionservice.domain.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Yanki {
    private Long id;
    private String idType;
    private Long phone;
    private String email;
    private Long imei;
    private BigDecimal balance;
    private String cardId;
}
