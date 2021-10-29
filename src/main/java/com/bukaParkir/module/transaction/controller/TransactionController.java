package com.bukaParkir.module.transaction.controller;

import com.bukaParkir.common.payload.BaseResponse;
import com.bukaParkir.module.transaction.payload.TransactionRequest;
import com.bukaParkir.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/payment/{id}")
    public BaseResponse paymentTransaction(@PathVariable Long id, TransactionRequest request){
        return transactionService.transaction(id, request);
    }
}
