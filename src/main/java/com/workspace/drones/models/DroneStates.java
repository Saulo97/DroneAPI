package com.workspace.drones.models;

public enum DroneStates {
    IDLE,
    LOADING,
    LOADED,
    DELIVERING,
    DELIVERED,
    RETURNING;
    
    public boolean isDroneState(String value){
        boolean result = false;
        for(DroneStates d : DroneStates.values()){
            if(d.toString().equalsIgnoreCase(value)){
                result = true;
                break;
            }else {
                return result;
            }
        }
        return result;
    }
}
