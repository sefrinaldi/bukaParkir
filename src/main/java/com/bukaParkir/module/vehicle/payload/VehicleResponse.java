package com.bukaParkir.module.vehicle.payload;

import com.bukaParkir.model.VehicleType;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public class VehicleResponse {

    private Long id;
    private VehicleType vehicleType;
    private String policeNumber;
    private Date dateIn;
    private Date timeIn;
    private String status;
}
