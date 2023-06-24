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
    private String model;
    @Column(name = "weight")
    private int weight;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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
