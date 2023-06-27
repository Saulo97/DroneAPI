package com.workspace.drones.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.workspace.drones.dto.MedicationDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
@Table(name = "medications")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    @Pattern(regexp = "^[a-zA-Z0-9-_]*$",message = "code only must have letter, numbers, '-', '_'")
    @NotBlank(message = "este dato no debe estar vacio o nulo")
    @NotNull(message = "este dato no debe estar vacio o nulo")
    private String name;
    @Column(name = "weight")
    @Min(1)
    private int weight;
    @Column(name = "code")
    @NotBlank(message = "este dato no debe estar vacio o nulo")
    @NotNull(message = "este dato no debe estar vacio o nulo")
    @Pattern(regexp = "^[0-9A-Z_]*$",message = "code only must have upper case, underscore and numbers")
    private String code;
    @Column(name = "image")
    @NotBlank(message = "este dato no debe estar vacio o nulo")
    @NotNull(message = "este dato no debe estar vacio o nulo")
    private String image;
    @ManyToOne()
    @JoinColumn(name = "drone_id")
    private Drone drone;
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
        return medicationDTO;
    }
}
