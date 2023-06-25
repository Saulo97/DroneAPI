package com.workspace.drones.controllers;
import com.workspace.drones.dto.DroneDTO;
import com.workspace.drones.models.Drone;
import com.workspace.drones.services.DroneServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("DroneAPI/Drone")
public class DroneController {
    @Autowired
    private DroneServiceIMP droneServiceIMP;

    @GetMapping
    @RequestMapping(value = "/getDrones", method = RequestMethod.GET)
    public ResponseEntity<?> getDrones(){
        List<DroneDTO> droneList = droneServiceIMP.showDrones();
        return ResponseEntity.ok(droneList);
    }

    @PostMapping
    @RequestMapping(value = "/registerDrone", method = RequestMethod.POST)
    public ResponseEntity<?> registerDrone(@RequestBody Drone drone){
        DroneDTO registeredDrone = droneServiceIMP.registerDrone(drone);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredDrone);
    }
    @PostMapping
    @RequestMapping(value = "/updateDrone", method = RequestMethod.PUT)
    public ResponseEntity<?> updateDrone(@RequestBody Drone drone){
        DroneDTO updatedDrone = droneServiceIMP.updateDrone(drone);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedDrone);
    }

    @GetMapping
    @RequestMapping(value = "/getDrone/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getDrone(@PathVariable int id){
        DroneDTO foundDrone = droneServiceIMP.findDroneById(id);
        return ResponseEntity.ok(foundDrone);
    }

    @DeleteMapping
    @RequestMapping(value = "/deleteDrone/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteDrone(@PathVariable int id){
        droneServiceIMP.deleteDroneById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @RequestMapping(value="/getAvailablesDrones",method = RequestMethod.GET)
    public ResponseEntity<?> getAvailableDron(){
        List<DroneDTO> list = droneServiceIMP.getAvailablesDrones();
        return ResponseEntity.ok(list);
    }

    @GetMapping
    @RequestMapping(value = "/checkBatteryLevel/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> checkBattery(@PathVariable int id){
        DroneDTO foundDrone = droneServiceIMP.findDroneById(id);
        return ResponseEntity.ok(foundDrone.getBatteryCapacity());
    }

    @GetMapping
    @RequestMapping(value = "/getDroneByLoadId/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getDroneByLoad(@PathVariable int id){
        DroneDTO foundDrone = droneServiceIMP.getDroneByMedicationId(id);
        return ResponseEntity.ok(foundDrone);
    }
}
