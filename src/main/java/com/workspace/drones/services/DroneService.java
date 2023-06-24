package com.workspace.drones.services;

import com.workspace.drones.DronesApplication;
import com.workspace.drones.models.Drone;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DroneService {
    public List<Drone> showDrones();
    public void registerDrone(Drone drone);
    public void updateDrone(Drone drone);
    public Drone findDroneById(int id);
    public void deleteDroneById(int id);
}
