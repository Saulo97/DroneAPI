package com.workspace.drones.services;
import com.workspace.drones.dto.DroneDTO;
import com.workspace.drones.models.Drone;
import com.workspace.drones.models.DroneStates;
import com.workspace.drones.models.Medication;
import com.workspace.drones.repositories.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DroneServiceIMP implements DroneService{
    @Autowired
    private DroneRepository droneRepository;
    @Override
    public List<DroneDTO> showDrones() {
        List<Drone> droneList = droneRepository.findAll();
        List<DroneDTO> allDrones = new ArrayList<DroneDTO>();
        droneList.forEach(drone->{
            allDrones.add(mapToDronDTO(drone));
        });
        return allDrones;
    }

    @Override
    public DroneDTO registerDrone(Drone drone) {
        Drone savedDrone=droneRepository.save(drone);
        return mapToDronDTO(savedDrone);
    }

    @Override
    public DroneDTO updateDrone(Drone drone) {
        Drone savedDrone=droneRepository.save(drone);
        return mapToDronDTO(savedDrone);
    }

    @Override
    public DroneDTO findDroneById(int id) {
        Drone foundDrone = droneRepository.findById(id).get();
        return mapToDronDTO(foundDrone);
    }

    @Override
    public void deleteDroneById(int id) {
        droneRepository.deleteById(id);
    }

    @Override
    public List<Medication> getLoadByDroneId(int id) {
        DroneDTO foundDrone = findDroneById(id);
        //List<Medication> loadDrone = foundDrone.getLoad();
       //List<Medication> loadList = new ArrayList<Medication>();
       // loadDrone.forEach(x->{
        //    Medication load = new Medication();
      //      load.setId(x.getId());
       //     load.setCode(x.getCode());
     //       load.setName(x.getName());
    //        load.setWeight(x.getWeight());
      //      load.setImage(x.getImage());
      //      loadList.add(load);
     //   });
      //  return loadList;
        return null;
    }

    @Override
    public List<DroneDTO> getAvailablesDrones() {
        List<Drone> dronelist = droneRepository.findDroneByStateEquals(DroneStates.IDLE);
        List<DroneDTO> availablesDrones = new ArrayList<DroneDTO>();
        dronelist.forEach(drone->{
            availablesDrones.add(mapToDronDTO(drone));
        });
        return availablesDrones;
    }

    public DroneDTO mapToDronDTO(Drone drone){
        DroneDTO droneDTO = new DroneDTO();
        droneDTO.setModel(drone.getModel());
        droneDTO.setSerialNumber(drone.getSerialNumber());
        droneDTO.setState(drone.getState());
        droneDTO.setBatteryCapacity(drone.getBatteryCapacity());
        droneDTO.setWeightLimit(drone.getWeightLimit());
        return droneDTO;
    }
}
