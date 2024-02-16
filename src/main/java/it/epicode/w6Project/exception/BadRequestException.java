package it.epicode.w6Project.exception;


public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
