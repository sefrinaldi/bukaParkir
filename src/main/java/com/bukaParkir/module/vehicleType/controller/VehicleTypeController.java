package com.bukaParkir.module.vehicleType.controller;

import com.bukaParkir.common.payload.BaseResponse;
import com.bukaParkir.module.vehicleType.payload.VehicleTypeRequest;
import com.bukaParkir.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicle-type")
public class VehicleTypeController {

    @Autowired
    VehicleTypeService vehicleTypeService;

    @PostMapping("/add")
    public BaseResponse addVehicleType(@RequestBody VehicleTypeRequest vehicleTypeRequest) {
        return vehicleTypeService.addVehicleType(vehicleTypeRequest);
    }

    @PostMapping("/update/{id}")
    public BaseResponse updateVehicle(@PathVariable Long id, @RequestBody VehicleTypeRequest vehicleTypeRequest) {
        return vehicleTypeService.updateVehicleType(id, vehicleTypeRequest);
    }

    @GetMapping("/get-all")
    public BaseResponse getAllVehicleType() {
        return vehicleTypeService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse deleteVehicleType(@PathVariable Long id) {
        return vehicleTypeService.deleteVehicleType(id);
    }
}
