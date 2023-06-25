package com.workspace.drones.controllers;

import com.workspace.drones.dto.MedicationDTO;
import com.workspace.drones.models.Medication;
import com.workspace.drones.services.MedicationServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("DroneAPI/Medications")
public class MedicationControllers {
    @Autowired
    MedicationServiceIMP medicationServiceIMP;

    @GetMapping
    @RequestMapping(value = "/findLoadByDroneId/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> findLoadByDroneId(@PathVariable int id){
        List<MedicationDTO> loadList = medicationServiceIMP.getLoadByDroneId(id);
        return ResponseEntity.ok(loadList);
    }
    @PostMapping
    @RequestMapping(value = "/loadingDrone",method = RequestMethod.POST)
    public ResponseEntity<?> loadingDrone(@RequestBody Medication medication){
        MedicationDTO medicationOrder = medicationServiceIMP.loadingDronById(medication);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicationOrder);
    }
    @GetMapping
    @RequestMapping(value = "/getAllOrders",method = RequestMethod.GET)
    public ResponseEntity<?> getAllMedicationsItems(){
        List<MedicationDTO> medicationDTOList = medicationServiceIMP.showAllMedications();
        return ResponseEntity.ok(medicationDTOList);
    }
    @GetMapping
    @RequestMapping(value = "/getMedicationById/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getMedicationById(@PathVariable int id){
        MedicationDTO result = medicationServiceIMP.findMedicationById(id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping
    @RequestMapping(value = "/deleteOrderById/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteById(@PathVariable int id){
        medicationServiceIMP.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
