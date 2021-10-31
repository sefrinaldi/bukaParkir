package com.bukaParkir.model;

import com.bukaParkir.common.auditable.ModelBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "vehicle_type")
public class VehicleType extends ModelBase {

    @NotNull
    @Column(name = "type", unique = true)
    private String type;

    @NotNull
    @Column(name = "price")
    private double price;

    public VehicleType() {
    }

    public VehicleType(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
