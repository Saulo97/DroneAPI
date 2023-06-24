package com.workspace.drones.services;

import com.workspace.drones.models.Drone;
import com.workspace.drones.repositories.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneServiceIMP implements DroneService{
    @Autowired
    private DroneRepository droneRepository;
    @Override
    public List<Drone> showDrones() {
        return (List<Drone>) droneRepository.findAll();
    }

    @Override
    public Drone registerDrone(Drone drone) {
        droneRepository.save(drone);
        return drone;
    }

    @Override
    public Drone updateDrone(Drone drone) {
        droneRepository.save(drone);
        return drone;
    }

    @Override
    public Drone findDroneById(int id) {
        return droneRepository.findById(id).get();
    }

    @Override
    public void deleteDroneById(int id) {
        droneRepository.deleteById(id);
    }
}
