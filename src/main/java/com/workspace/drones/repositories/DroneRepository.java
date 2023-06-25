package com.workspace.drones.repositories;

import com.workspace.drones.models.Drone;
import com.workspace.drones.models.DroneStates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Integer> {
    List<Drone> findDroneByStateEquals(DroneStates state);
}
