package com.example.bus_ticket_reservation_app_resttemplate.global_exception;

public class CustomizeException extends RuntimeException{
    private String message;
    private Object status;
    private Object data;
    public CustomizeException(String message , Object status,Object data){
        this.data = data;
        this.message = message;
        this.status = status;
    }
}
