package com.workspace.drones.customException;

public class NotLoadDroneException extends Exception{
    public NotLoadDroneException(String mensaje){
        super(mensaje);
    }
}
