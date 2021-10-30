package com.bukaParkir.service.impl;

import com.bukaParkir.common.payload.BaseResponse;
import com.bukaParkir.common.payload.CommonMessage;
import com.bukaParkir.model.Vehicle;
import com.bukaParkir.model.VehicleType;
import com.bukaParkir.module.vehicle.payload.VehicleRequest;
import com.bukaParkir.module.vehicle.payload.VehicleResponse;
import com.bukaParkir.repository.VehicleRepository;
import com.bukaParkir.repository.VehicleTypeRepository;
import com.bukaParkir.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    VehicleTypeRepository vehicleTypeRepository;

    @Override
    public BaseResponse addVehicle(VehicleRequest vehicleRequest) {
        try {
            Vehicle vehicle = new Vehicle();
            VehicleType vehicleType = vehicleTypeRepository.findById(vehicleRequest.getVehicleTypeId())
                    .orElse(null);
            vehicle.setVehicleType(vehicleType);
            vehicle.setPoliceNumber(vehicleRequest.getPoliceNumber());
//            vehicle.setDateIn(vehicleRequest.getDateIn());
//            vehicle.setTimeIn(new Date());
            vehicle.setStatus("in");


            vehicleRepository.save(vehicle);

            VehicleResponse response = new VehicleResponse();
            response.setId(vehicle.getId());
            response.setVehicleType(vehicle.getVehicleType());
            response.setPoliceNumber(vehicle.getPoliceNumber());
            response.setDateIn(vehicle.getDateIn());
            response.setTimeIn(vehicle.getTimeIn());
            response.setStatus(vehicle.getStatus());

            return new BaseResponse(CommonMessage.SAVED, 200, response);
        } catch (Exception e) {
            return new BaseResponse(CommonMessage.NOT_SAVED, 400);
        }
    }

    @Override
    public BaseResponse getAllVehicle() {
        try {
            List<Vehicle> vehicleList = vehicleRepository.findAll();
            return new BaseResponse(CommonMessage.FOUND, 200, vehicleList);
        } catch (Exception e) {
            return new BaseResponse(CommonMessage.NOT_FOUND, 400);
        }
    }

    @Override
    public BaseResponse updateVehicle(Long id, VehicleRequest vehicleRequest) {
        try {
            Vehicle vehicle = vehicleRepository.findById(id).get();
            VehicleType vehicleType = vehicleTypeRepository.findById(vehicleRequest.getVehicleTypeId())
                    .orElse(null);

            vehicle.setVehicleType(vehicleType);
            vehicle.setPoliceNumber(vehicleRequest.getPoliceNumber());
            vehicle.setDateOut(vehicleRequest.getDateOut());
            vehicle.setTimeOut(vehicleRequest.getTimeOut());
            if (vehicle.getDateOut() != null && vehicle.getTimeOut() != null) {
                vehicle.setStatus("out");
            }

            vehicleRepository.save(vehicle);
            return new BaseResponse(CommonMessage.UPDATED, 200, vehicle);
        } catch (Exception e) {
            return new BaseResponse(CommonMessage.NOT_UPDATED, 400);
        }
    }

    @Override
    public BaseResponse deleteVehicle(Long id) {
        try {
            Vehicle vehicle = vehicleRepository.findById(id)
                    .orElse(new Vehicle());

            vehicle.setStatus("out");

            vehicleRepository.save(vehicle);
            return new BaseResponse(CommonMessage.DELETED, 200);
        } catch (Exception e) {
            return new BaseResponse(CommonMessage.NOT_DELETED, 400);
        }
    }

    @Override
    public BaseResponse getPoliceNumber(String policeNumber) {
        try {
            Vehicle vehicle = vehicleRepository.findByPoliceNumberAndStatus(policeNumber, "in");
//            VehicleType vehicleType = vehicleTypeRepository.findById(vehicle.getVehicleType().getId()).get();
//
//            vehicle.setVehicleType(vehicleType);
//            vehicle.setPoliceNumber(policeNumber);
            vehicle.setDateOut(new Date());
            vehicle.setTimeOut(new Date());
            if (vehicle.getDateOut() != null && vehicle.getTimeOut() != null) {
                vehicle.setStatus("out");
            }

            vehicleRepository.save(vehicle);
            return new BaseResponse(CommonMessage.UPDATED, 200, vehicle);
        } catch (Exception e) {
            return new BaseResponse(CommonMessage.NOT_FOUND, 400);
        }
    }
}
