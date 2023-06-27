package com.workspace.drones.models;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.workspace.drones.dto.DroneDTO;
import com.workspace.drones.dto.MedicationDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jakarta.validation.valueextraction.ExtractedValue;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "drones")
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Size(max = 100, message = "El numero de serie debe tener un maximo de 100 caracteres")
    @NotBlank(message = "este dato no debe estar vacio o ser null")
    @NotNull(message = "este dato no debe estar vacio o ser null")
    @Column(name = "serial_number")
    private String serialNumber;
    @Column(name = "model")
    private DroneModel model;
    @Column(name = "weight_limit")
    @Min(value = 1,message = "El limite de peso debe ser mayor que 0")
    private int weightLimit;
    @Min(value = 1, message = "La capacidad de la bateria debe ser un valor entre 0 y 100")
    @Max(value = 100, message = "La capacidad de la bateria debe ser un valor entre 0 y 100")
    @Column(name = "battery_capacity")
    private int batteryCapacity;
    @Column(name = "state")
    private DroneStates state;
    @OneToMany(mappedBy = "drone", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Medication> load;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public DroneModel getModel() {
        return model;
    }

    public void setModel(DroneModel model) {
        this.model = model;
    }

    public int getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(int weightLimit) {
        this.weightLimit = weightLimit;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public DroneStates getState() {
        return state;
    }

    public void setState(DroneStates state) {
        this.state = state;
    }

    public List<Medication> getLoad() {
        return load;
    }

    public void setLoad(List<Medication> load) {
        this.load = load;
    }
    public DroneDTO mapToDronDTO(){
        DroneDTO droneDTO = new DroneDTO();
        droneDTO.setId(this.getId());
        droneDTO.setModel(this.getModel());
        droneDTO.setSerialNumber(this.getSerialNumber());
        droneDTO.setState(this.getState());
        droneDTO.setBatteryCapacity(this.getBatteryCapacity());
        droneDTO.setWeightLimit(this.getWeightLimit());
        List<Medication> loadlist = this.getLoad();
        List<MedicationDTO> loadListDTO = new ArrayList<MedicationDTO>();
        loadlist.forEach(load->{
            loadListDTO.add(load.mapToDTO());
        });
        droneDTO.setLoad(loadListDTO);
        return droneDTO;
    }

}
