package com.workspace.drones;

import com.workspace.drones.customException.MaxWeightException;
import com.workspace.drones.customException.NotLoadDroneException;
import com.workspace.drones.customException.WeightLimitException;
import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
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
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlerPropertyValueException (PropertyValueException exception){
        return "Rellene todos los campos correctament" ;
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handlerNullPointerException(NullPointerException exception){
        return "No se encuentra el elemento especificado";
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String HttpMessageNotReadableException(HttpMessageNotReadableException exception){
        String m = exception.getMessage();
        System.out.println(m);
        return "Rellene todos los campos correctamente";
    }
    @ExceptionHandler(MaxWeightException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handlerMaxWeightException(MaxWeightException exception){
        return "El peso limite para un drone es de 500 gramos";
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String , String> handleValidateExceptions(MethodArgumentNotValidException exception){
        Map<String,String> errors = new HashMap<String, String>();
        exception.getBindingResult().getAllErrors().forEach(error->{
            String fieldError = ((FieldError) error).getField();
            String message = error.getDefaultMessage();

            errors.put(fieldError, message);
        });

        return errors;
    }

}
