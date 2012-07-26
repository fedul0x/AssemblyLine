package ru.fedul0x.wavepredict.assemblyline.filter.exception;

/**
 *
 * @author Ivashin Alexey
 */
public class InvalidFilterTargetTypeException extends Exception{

    public InvalidFilterTargetTypeException(Throwable cause) {
        super(cause);
    }

    public InvalidFilterTargetTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidFilterTargetTypeException(String message) {
        super(message);
    }

    public InvalidFilterTargetTypeException() {
    }
    
    
}
