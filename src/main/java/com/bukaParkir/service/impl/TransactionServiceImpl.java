package com.bukaParkir.service.impl;

import com.bukaParkir.common.payload.BaseResponse;
import com.bukaParkir.common.payload.CommonMessage;
import com.bukaParkir.model.Transaction;
import com.bukaParkir.model.Vehicle;
import com.bukaParkir.module.transaction.payload.TransactionRequest;
import com.bukaParkir.repository.TransactionRepository;
import com.bukaParkir.repository.VehicleRepository;
import com.bukaParkir.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public BaseResponse transaction(Long id, TransactionRequest request) {
        try {
            Vehicle vehicle = vehicleRepository.findById(id).get();

            if (vehicle != null) {
                vehicle.setDateOut(request.getDateOut());
                vehicle.setTimeOut(request.getTimeOut());
                vehicle.setStatus("out");
                vehicleRepository.save(vehicle);

                Transaction transaction = new Transaction();
                transaction.setVehicle(vehicle);
                transaction.setTotalPrice(50000);
                transactionRepository.save(transaction);

                return new BaseResponse(CommonMessage.SAVED, 200, transaction);

            } else {
                return new BaseResponse(CommonMessage.NOT_FOUND, 400);
            }
        } catch (Exception e) {
            return new BaseResponse(CommonMessage.NOT_FOUND, 400);
        }
    }
}
