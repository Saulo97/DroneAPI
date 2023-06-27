package com.workspace.drones.dto;

import com.workspace.drones.models.DroneModel;
import com.workspace.drones.models.DroneStates;
import com.workspace.drones.models.Medication;

import java.util.List;

public class DroneDTO {
    private int id;
    private String serialNumber;
    private DroneModel model;
    private int weightLimit;
    private int batteryCapacity;
    private DroneStates state;
    private List<MedicationDTO> load;

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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MedicationDTO> getLoad() {
        return load;
    }

    public void setLoad(List<MedicationDTO> load) {
        this.load = load;
    }
}
