package com.workspace.drones.customException;

public class WeightLimitException extends Exception{
    public WeightLimitException(String mensaje){
        super(mensaje);
    }
}
