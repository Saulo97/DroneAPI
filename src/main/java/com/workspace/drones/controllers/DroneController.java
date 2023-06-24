package com.workspace.drones.controllers;

import com.workspace.drones.models.Drone;
import com.workspace.drones.services.DroneServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("DroneAPI")
public class DroneController {
    @Autowired
    private DroneServiceIMP droneServiceIMP;

    @GetMapping
    @RequestMapping(value = "/getDrones", method = RequestMethod.GET)
    public ResponseEntity<?> getDrones(){
        List<Drone> droneList = droneServiceIMP.showDrones();
        return ResponseEntity.ok(droneList);
    }

    @PostMapping
    @RequestMapping(value = "/registerDrone", method = RequestMethod.POST)
    public ResponseEntity<?> registerDrone(@RequestBody Drone drone){
        Drone registeredDrone = droneServiceIMP.registerDrone(drone);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredDrone);
    }
}
