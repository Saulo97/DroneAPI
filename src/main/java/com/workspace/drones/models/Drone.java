package com.workspace.drones.models;

import com.workspace.drones.dto.DroneDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "drones")
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;
    @Column(name = "serialNumber",nullable = false)
    private String serialNumber;
    @Column(name = "model",nullable = false)
    private DroneModel model;
    @Column(name = "weightLimit",nullable = false)
    private int weightLimit;
    @Column(name = "batteryCapacity",nullable = false)
    private int batteryCapacity;
    @Column(name = "state",nullable = false)
    private DroneStates state;
    @OneToOne(mappedBy = "drone", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Medication load;

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

    public Medication getLoad() {
        return load;
    }

    public void setLoad(Medication load) {
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
        return droneDTO;
    }

}
