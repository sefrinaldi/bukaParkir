package com.bukaParkir.module.vehicle.controller;

import com.bukaParkir.common.payload.BaseResponse;
import com.bukaParkir.module.vehicle.payload.VehicleRequest;
import com.bukaParkir.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping("/add")
    public BaseResponse addVehicle(@RequestBody VehicleRequest vehicleRequest) {
        return vehicleService.addVehicle(vehicleRequest);
    }

    @GetMapping("/get-all")
    public BaseResponse getAllVehicle() {
        return vehicleService.getAllVehicle();
    }

    @PostMapping("/update/{id}")
    public BaseResponse updateVehicle(@PathVariable Long id, @RequestBody VehicleRequest vehicleRequest) {
        return vehicleService.updateVehicle(id, vehicleRequest);
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse deleteVehicle(@PathVariable Long id) {
        return vehicleService.deleteVehicle(id);
    }
}
