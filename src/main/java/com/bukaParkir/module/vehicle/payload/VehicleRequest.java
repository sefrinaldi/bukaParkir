package com.bukaParkir.module.vehicle.payload;

import com.bukaParkir.model.VehicleType;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;

@Data
public class VehicleRequest {

    private Long vehicleTypeId;
    private String policeNumber;
    private Date dateIn;
    private Date dateOut;
    private Time timeIn;
    private Time timeOut;
    private String status;
}
