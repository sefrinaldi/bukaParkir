package com.bukaParkir.module.transaction.payload;

import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public class TransactionRequest {

    private Long vehicleId;
    private Date dateOut;
    private Time timeOut;
}
