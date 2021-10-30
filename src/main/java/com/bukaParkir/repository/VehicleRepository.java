package com.bukaParkir.repository;

import com.bukaParkir.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Vehicle findByPoliceNumberAndStatus(String policeNumber, String status);
}
