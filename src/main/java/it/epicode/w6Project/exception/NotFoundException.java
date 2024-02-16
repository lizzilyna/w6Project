package it.epicode.w6Project.exception;


public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}
