package com.blc.eventManagement.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String entityName;
    private String fieldName;
    private long fieldValue;

    public ResourceNotFoundException(String entityName, String fieldName, long fieldValue) {
        super(String.format("%s not found with %s : '%s'", entityName, fieldName, fieldValue));

        this.entityName = entityName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}