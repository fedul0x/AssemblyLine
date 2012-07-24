package ru.fedul0x.assemblyline.filter.exception;

/**
 * Exception throw when invoke method {@code start()} have a null pointer in {@code sourceData} field
 * @see Filter
 * @author Ivashin Alexey
 */
public class NullFilterException extends Exception {

    public NullFilterException(Throwable cause) {
        super(cause);
    }

    public NullFilterException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullFilterException(String message) {
        super(message);
    }

    public NullFilterException() {
    }
    
    
}
