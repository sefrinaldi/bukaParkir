package com.bukaParkir.service;

import com.bukaParkir.common.payload.BaseResponse;
import com.bukaParkir.module.vehicle.payload.VehicleRequest;

public interface VehicleService {

    BaseResponse addVehicle(VehicleRequest vehicleRequest);

    BaseResponse getAllVehicle();

    BaseResponse updateVehicle(Long id, VehicleRequest vehicleRequest);

    BaseResponse deleteVehicle(Long id);
}
