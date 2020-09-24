/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.utils;

import java.io.Serializable;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ahmed Hafez
 */
@Component
public class RecordNotFoundException extends Exception implements Serializable{
    
    private String message;

    public RecordNotFoundException() {
        this("Record Not Found!!");
    }

    public RecordNotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
}
