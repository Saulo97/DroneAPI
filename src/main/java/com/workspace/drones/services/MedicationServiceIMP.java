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
    public List<MedicationDTO> getLoadByDroneId(int id) {
        List<Medication> foundMedication = medicationRepository.findMedicationsByDroneId(id);
        List<MedicationDTO> medication = new ArrayList<MedicationDTO>();
        foundMedication.forEach(load->{
            medication.add(load.mapToDTO());
        });
        return medication;
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
        List<Medication> loadTargetDrone = targetDrone.getLoad();
        int actualWeight = 0;
        for(Medication load: loadTargetDrone){
            actualWeight=+ load.getWeight();
        }
        if(targetDrone.getWeightLimit() < medication.getWeight()+actualWeight){
            throw new WeightLimitException("The medication's weight is more that expect");
        } else if(targetDrone.getState()==DroneStates.DELIVERING) {
            throw new NotLoadDroneException("This drone is not available");
        }else{
            medication.setDrone(targetDrone);
            Medication newMedication = medicationRepository.save(medication);
            droneRepository.save(targetDrone);
            return newMedication.mapToDTO();
        }
    }

    @Override
    public MedicationDTO findMedicationById(int id){
        return medicationRepository.findById(id).get().mapToDTO();
    }

    @Override
    public void deleteById(int id) {
        medicationRepository.deleteById(id);
    }


}
