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

import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public BaseResponse transaction(String policeNumber) {
        try {
            Vehicle vehicle = vehicleRepository.findByPoliceNumberAndStatus(policeNumber, "in");

            if (vehicle != null) {

                vehicle.setDateOut(new Date());
                vehicle.setTimeOut(new Date());
                vehicle.setStatus("out");
                vehicleRepository.save(vehicle);

                Transaction transaction = new Transaction();
                transaction.setVehicle(vehicle);
                Long time = vehicle.getTimeOut().getTime() - vehicle.getTimeIn().getTime();
                Long diffInMinute = (time / (1000 * 60)) % 60;
                Long diffInHour = (time / (1000 * 60 * 60)) % 24;

                if (diffInMinute < 10) {
                    if (diffInHour < 2) {
                        diffInHour = 1L;
                    }
                } else {
                    diffInHour++;
                }

                double price = diffInHour * vehicle.getVehicleType().getPrice();

                transaction.setTotalPrice(price);
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
