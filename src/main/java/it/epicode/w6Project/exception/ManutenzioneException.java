package it.epicode.w6Project.exception;

import jdk.jshell.spi.ExecutionControl;

public class ManutenzioneException extends RuntimeException {
    public ManutenzioneException(String message){
        super(message);
    }
}
