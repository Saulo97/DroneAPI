package com.workspace.drones.services;
import com.workspace.drones.dto.DroneDTO;
import com.workspace.drones.models.Drone;
import com.workspace.drones.models.Medication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DroneService {
    public List<DroneDTO> showDrones();
    public DroneDTO registerDrone(Drone drone);
    public DroneDTO updateDrone(Drone drone);
    public DroneDTO findDroneById(int id);
    public void deleteDroneById(int id);
    public List<Medication> getLoadByDroneId(int id);
    public List<DroneDTO> getAvailablesDrones();
}
