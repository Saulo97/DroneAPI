package com.workspace.drones.services;

import com.workspace.drones.dto.MedicationDTO;
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
    @Override
    public List<MedicationDTO> getLoadByDroneId(int id) {
        List<Medication> foundMedication = medicationRepository.findMedicationsByDroneId(id);
        List<MedicationDTO> listMedication = new ArrayList<MedicationDTO>();
        foundMedication.forEach(medication->{
            listMedication.add(medication.mapToDTO());
        });
        return listMedication;
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
    public MedicationDTO loadingDronById(Medication medication) {
        Medication newMedication = medicationRepository.save(medication);
        return newMedication.mapToDTO();
    }

    @Override
    public MedicationDTO findMedicationById(int id) {
        return medicationRepository.findById(id).get().mapToDTO();
    }

    @Override
    public void deleteById(int id) {
        medicationRepository.deleteById(id);
    }


}
