package com.workspace.drones.services;
import com.workspace.drones.dto.DroneDTO;
import com.workspace.drones.models.Drone;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DroneService {
    public List<DroneDTO> showDrones();
    public DroneDTO registerDrone(Drone drone);
    public DroneDTO updateDrone(Drone drone);
    public DroneDTO findDroneById(int id) throws Exception;
    public void deleteDroneById(int id);
    public List<DroneDTO> getAvailablesDrones();
    public DroneDTO getDroneByMedicationId(int id);
}
