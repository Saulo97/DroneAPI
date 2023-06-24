package com.workspace.drones.models;

import jakarta.persistence.*;

@Entity
@Table(name = "medications")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "weight")
    private int weight;
    @Column(name = "code")
    private String code;
    @Column(name = "image")
    private String image;
    @ManyToOne
    private Drone drones;

    public Medication(){

    }

    public void setId(int id) {
        this.id = id;
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

    public Drone getDrone() {
        return drones;
    }

    public void setDrone(Drone drone) {
        this.drones = drone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
