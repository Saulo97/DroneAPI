package com.workspace.drones;

import com.workspace.drones.customException.NotLoadDroneException;
import com.workspace.drones.customException.WeightLimitException;
import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class HandlerException {
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handlerNoSuchElementException( NoSuchElementException exception){
        return "No se ha encontrado el elemento especificado";
    }

    @ExceptionHandler(NotLoadDroneException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handlerNotLoadDroneException( NotLoadDroneException exception){
        return "El dron seleccionado no se encuentra disponible";
    }

    @ExceptionHandler(WeightLimitException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public  String handlerWeightLimitException( WeightLimitException exception){
        return "El peso del medicamento excede el peso limite del dron";
    }

    @ExceptionHandler(PropertyValueException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handlerPropertyValueException (PropertyValueException exception){
        return "Rellene todos los campos ";
    }
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handlerNullPointerException(NullPointerException exception){
        return "No se encuentra el elemento especificado";
    }
}
