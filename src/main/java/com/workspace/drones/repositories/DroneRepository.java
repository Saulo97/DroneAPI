package com.workspace.drones.repositories;

import com.workspace.drones.models.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Integer> {
}
