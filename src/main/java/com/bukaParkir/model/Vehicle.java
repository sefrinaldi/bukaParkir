package com.bukaParkir.model;

import com.bukaParkir.common.auditable.ModelBase;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "vehicle")
public class Vehicle extends ModelBase {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "fk_vehicle_type_id")
    private VehicleType vehicleType;

    @NotNull
    @Column(name = "police_number")
    private String policeNumber;

//    @NotNull
    @CreatedDate
    @Temporal(TemporalType.DATE)
    @Column(name = "date_in")
    private Date dateIn;


    @Temporal(TemporalType.DATE)
    @Column(name = "date_out")
    private Date dateOut;

//    @NotNull
    @Temporal(TemporalType.TIME)
    @Column(name = "time_in")
    private Date timeIn;

    @Temporal(TemporalType.TIME)
    @Column(name = "time_out")
    private Date timeOut;

    @NotNull
    @Column(name = "status")
    private String status;

    @PrePersist
    private void onCreate() {
        dateIn = new Date();
        timeIn = new Date();
    }

    public Vehicle() {
    }

    public Vehicle(VehicleType vehicleType, String policeNumber, Date dateIn, Date timeIn, String status) {
        this.vehicleType = vehicleType;
        this.policeNumber = policeNumber;
        this.dateIn = dateIn;
        this.timeIn = timeIn;
        this.status = status;
    }

    public Vehicle(VehicleType vehicleType, String policeNumber, Date dateIn, Date dateOut, Date timeIn, Date timeOut, String status) {
        this.vehicleType = vehicleType;
        this.policeNumber = policeNumber;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.status = status;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setPoliceNumber(String policeNumber) {
        this.policeNumber = policeNumber;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public void setTimeIn(Date timeIn) {
        this.timeIn = timeIn;
    }

    public void setTimeOut(Date timeOut) {
        this.timeOut = timeOut;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getPoliceNumber() {
        return policeNumber;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public Date getTimeIn() {
        return timeIn;
    }

    public Date getTimeOut() {
        return timeOut;
    }

    public String getStatus() {
        return status;
    }
}
