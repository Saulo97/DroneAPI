package com.workspace.drones.dto;

import com.workspace.drones.models.Medication;

public class MedicationDTO {
    private int id;
    private String name;
    private int weight;
    private String code;
    private String image;
    private DroneDTO drone;
    public MedicationDTO(){

    }

    public DroneDTO getDrone() {
        return drone;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setDrone(DroneDTO drone) {
        this.drone = drone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
