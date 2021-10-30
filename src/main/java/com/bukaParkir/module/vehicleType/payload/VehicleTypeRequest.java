package com.bukaParkir.module.vehicleType.payload;

import lombok.Data;

@Data
public class VehicleTypeRequest {

    private Long id;
    private String type;
    private double price;
}
