package com.vccaplication.vccapplication.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ResourceException extends Exception {
    private List<String> errorMessages = new ArrayList<>();

    public ResourceException(){

    }

    public ResourceException(String message){
        super(message);
    }
    public void addErrorMessage(String message) {
        this.errorMessages.add(message);
    }

}
