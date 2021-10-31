package com.bukaParkir.model;

import com.bukaParkir.common.auditable.ModelBase;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "transaction")
public class Transaction extends ModelBase {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "fk_vehicle_id")
    private Vehicle vehicle;

    @NotNull
    @Column
    private double totalPrice;

    public Transaction() {
    }

    public Transaction(Vehicle vehicle, double totalPrice) {
        this.vehicle = vehicle;
        this.totalPrice = totalPrice;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
