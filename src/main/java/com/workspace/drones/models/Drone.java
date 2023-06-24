package com.workspace.drones.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "drones")
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "serialNumber")
    private String serialNumber;
    @Column(name = "model")
    private DroneModel model;
    @Column(name = "weightLimit")
    private int weightLimit;
    @Column(name = "batteryCapacity")
    private int batteryCapacity;
    @Column(name = "state")
    private DroneStates state;
    @OneToMany(mappedBy = "drones")
    private List<Medication> load;

    public Drone(){

    }
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
}
