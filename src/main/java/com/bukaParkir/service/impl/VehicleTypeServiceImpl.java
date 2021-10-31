package com.bukaParkir.service.impl;

import com.bukaParkir.common.payload.BaseResponse;
import com.bukaParkir.common.payload.CommonMessage;
import com.bukaParkir.model.VehicleType;
import com.bukaParkir.module.vehicleType.payload.VehicleTypeRequest;
import com.bukaParkir.repository.VehicleTypeRepository;
import com.bukaParkir.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleTypeServiceImpl implements VehicleTypeService {

    @Autowired
    VehicleTypeRepository vehicleTypeRepository;

    @Override
    public BaseResponse addVehicleType(VehicleTypeRequest vehicleTypeRequest) {
        try {
            VehicleType vehicleType = new VehicleType();
            vehicleType.setType(vehicleTypeRequest.getType());
            vehicleType.setPrice(vehicleTypeRequest.getPrice());

            if (vehicleType.getType() != null && vehicleType.getPrice() != 0){
                vehicleTypeRepository.save(vehicleType);
                return new BaseResponse(CommonMessage.SAVED, 200, vehicleType);
            }

            return new BaseResponse(CommonMessage.NOT_SAVED, 400);
        } catch (Exception e) {
            return new BaseResponse(CommonMessage.NOT_SAVED, 400);
        }
    }

    @Override
    public BaseResponse updateVehicleType(Long id, VehicleTypeRequest vehicleTypeRequest) {
        try {
            VehicleType vehicleType = vehicleTypeRepository.findById(id)
                    .orElseThrow(()->new NullPointerException(CommonMessage.NOT_FOUND + id));

            vehicleType.setType(vehicleTypeRequest.getType());
            vehicleType.setPrice(vehicleTypeRequest.getPrice());
            vehicleTypeRepository.save(vehicleType);

            return new BaseResponse(CommonMessage.UPDATED, 200, vehicleType);
        } catch (Exception e) {
            return new BaseResponse(CommonMessage.NOT_UPDATED, 400);
        }
    }

    @Override
    public BaseResponse getAll() {
        try {
            List<VehicleType> vehicleTypeList = vehicleTypeRepository.findAll();
            return new BaseResponse(CommonMessage.FOUND, 200, vehicleTypeList);
        } catch (Exception e) {
            return new BaseResponse(CommonMessage.NOT_FOUND, 400);
        }
    }

    @Override
    public BaseResponse deleteVehicleType(Long id) {
        try {
            VehicleType vehicleType = vehicleTypeRepository.findById(id)
                    .orElse(new VehicleType());

            vehicleTypeRepository.delete(vehicleType);
            return new BaseResponse(CommonMessage.DELETED, 200);
        } catch (Exception e) {
            return new BaseResponse(CommonMessage.NOT_DELETED, 400);
        }
    }
}
