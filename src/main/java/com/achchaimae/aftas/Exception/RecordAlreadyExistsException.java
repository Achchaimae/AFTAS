package com.achchaimae.aftas.Exception;



public class RecordAlreadyExistsException extends RuntimeException{
    public RecordAlreadyExistsException(String message){
        super(message);
    }
}