package com.bukaParkir.service;

import com.bukaParkir.common.payload.BaseResponse;
import com.bukaParkir.module.vehicleType.payload.VehicleTypeRequest;

public interface VehicleTypeService {

    BaseResponse addVehicleType(VehicleTypeRequest vehicleTypeRequest);

    BaseResponse updateVehicleType(Long id, VehicleTypeRequest vehicleTypeRequest);

    BaseResponse getAll();

    BaseResponse deleteVehicleType(Long id);
}
