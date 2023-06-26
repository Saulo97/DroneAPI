package com.workspace.drones;

import com.workspace.drones.dto.DroneDTO;
import com.workspace.drones.services.DroneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PeriodicTask {
    @Autowired
    DroneService droneService;
    private static Logger log = LoggerFactory.getLogger(PeriodicTask.class);
    @Scheduled(fixedRate = 5000)
    public void periodicTask(){
        List<DroneDTO> droneDTOList = droneService.showDrones();
        droneDTOList.forEach(drone->{
            log.info("El dron con numero de serie "+drone.getSerialNumber()+" tiene un nivel de bateria de un "+drone.getBatteryCapacity()+" porciento");
        });
    }
}
