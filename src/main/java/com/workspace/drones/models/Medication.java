package com.workspace.drones.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.workspace.drones.dto.MedicationDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @OneToOne()
    @JoinColumn(name = "drone_id")
    private Drone drone;
    public Medication(){}
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
        return drone;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public MedicationDTO mapToDTO(){
        MedicationDTO medicationDTO = new MedicationDTO();
        medicationDTO.setId(this.getId());
        medicationDTO.setCode(this.getCode());
        medicationDTO.setName(this.getName());
        medicationDTO.setImage(this.getImage());
        medicationDTO.setWeight(this.getWeight());
        medicationDTO.setDrone(this.getDrone().mapToDronDTO());
        return medicationDTO;
    }
}
