package com.bukaParkir.repository;

import com.bukaParkir.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

//    Vehicle findByPoliceNumberStatusIn(String policeNumber);
}
