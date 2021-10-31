package com.bukaParkir.service;

import com.bukaParkir.common.payload.BaseResponse;
import com.bukaParkir.module.transaction.payload.TransactionRequest;

public interface TransactionService {

    BaseResponse transaction(String policeNumber);
}
