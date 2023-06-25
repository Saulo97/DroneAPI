package com.workspace.drones.services;

import com.workspace.drones.customException.NotLoadDroneException;
import com.workspace.drones.customException.WeightLimitException;
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
public class MedicationServiceIMP implements MedicationService{
    @Autowired
    MedicationRepository medicationRepository;
    @Autowired
    DroneRepository droneRepository;
    @Override
    public MedicationDTO getLoadByDroneId(int id) {
        Medication foundMedication = medicationRepository.findMedicationsByDroneId(id);
        return foundMedication.mapToDTO();
    }

    @Override
    public List<MedicationDTO> showAllMedications() {
        List<Medication> result = medicationRepository.findAll();
        List<MedicationDTO> allMedicationOrders = new ArrayList<MedicationDTO>();
        result.forEach(item->{
            allMedicationOrders.add(item.mapToDTO());
        });
        return allMedicationOrders;
    }

    @Override
    public MedicationDTO loadingDronById(Medication medication, int id) throws NotLoadDroneException, WeightLimitException {
        Drone targetDrone = droneRepository.findById(id).get();
        if(targetDrone.getWeightLimit() < medication.getWeight()){
            throw new WeightLimitException("The medication's weight is more that expect");
        } else if(targetDrone.getState()==DroneStates.IDLE) {
            medication.setDrone(targetDrone);
            Medication newMedication = medicationRepository.save(medication);
            targetDrone.setState(DroneStates.LOADED);
            droneRepository.save(targetDrone);
            return newMedication.mapToDTO();
        }else{
            throw new NotLoadDroneException("This drone is not available");
        }
    }

    @Override
    public MedicationDTO findMedicationById(int id){
        return medicationRepository.findById(id).get().mapToDTO();
    }

    @Override
    public void deleteById(int id) {
        Medication targetMedication = medicationRepository.findById(id).get();
        Drone targetDrone = droneRepository.findById(targetMedication.getDrone().getId()).get();
        targetDrone.setLoad(null);
        targetDrone.setState(DroneStates.IDLE);
        droneRepository.save(targetDrone);
    }


}
