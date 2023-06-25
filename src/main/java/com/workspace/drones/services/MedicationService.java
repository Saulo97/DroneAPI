package com.workspace.drones.services;

import com.workspace.drones.dto.DroneDTO;
import com.workspace.drones.dto.MedicationDTO;
import com.workspace.drones.models.Drone;
import com.workspace.drones.models.Medication;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MedicationService {
    public List<MedicationDTO> getLoadByDroneId(int id);
    public List<MedicationDTO> showAllMedications();
    public MedicationDTO loadingDronById(Medication medication);
    public MedicationDTO findMedicationById(int id);
    public void deleteById(int id);


}
