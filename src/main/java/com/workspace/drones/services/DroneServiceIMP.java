package com.workspace.drones.services;
import com.workspace.drones.dto.DroneDTO;
import com.workspace.drones.dto.MedicationDTO;
import com.workspace.drones.models.Drone;
import com.workspace.drones.models.DroneStates;
import com.workspace.drones.models.Medication;
import com.workspace.drones.repositories.DroneRepository;
import com.workspace.drones.repositories.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DroneServiceIMP implements DroneService{
    @Autowired
    private DroneRepository droneRepository;
    @Autowired
    private MedicationRepository medicationRepository;
    @Override
    public List<DroneDTO> showDrones() {
        List<Drone> droneList = droneRepository.findAll();
        List<DroneDTO> allDrones = new ArrayList<DroneDTO>();
        droneList.forEach(drone->{
            allDrones.add(drone.mapToDronDTO());
        });
        return allDrones;
    }

    @Override
    public DroneDTO registerDrone(Drone drone) {
        Drone savedDrone=droneRepository.save(drone);
        return savedDrone.mapToDronDTO();
    }

    @Override
    public DroneDTO updateDrone(Drone drone) {
        Drone savedDrone=droneRepository.save(drone);
        return savedDrone.mapToDronDTO();
    }

    @Override
    public DroneDTO findDroneById(int id) {
        Drone foundDrone = droneRepository.findById(id).get();
        return foundDrone.mapToDronDTO();
    }

    @Override
    public void deleteDroneById(int id) {
        Drone targetDrone = droneRepository.findById(id).get();
        List<Medication> load = targetDrone.getLoad();
        load.forEach(medication->medicationRepository.deleteById(medication.getId()));
        droneRepository.deleteById(targetDrone.getId());
    }



    @Override
    public List<DroneDTO> getAvailablesDrones() {
        List<Drone> dronelist = droneRepository.findDroneByStateEquals(DroneStates.IDLE);
        List<DroneDTO> availablesDrones = new ArrayList<DroneDTO>();
        dronelist.forEach(drone->{
            availablesDrones.add(drone.mapToDronDTO());
        });
        return availablesDrones;
    }

    @Override
    public DroneDTO getDroneByMedicationId(int id) {
        Medication targetMedication = medicationRepository.findById(id).get();
        DroneDTO result = droneRepository.findDroneByLoad(targetMedication).mapToDronDTO();
        return result;
    }
}
