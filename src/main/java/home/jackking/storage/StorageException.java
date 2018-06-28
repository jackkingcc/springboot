package home.jackking.storage;

/**
 * Created by e604847 on 6/28/2018.
 */
public class StorageException extends RuntimeException {

    public StorageException(String message){
        super(message);
    }

    public StorageException(String message,Throwable cause){
        super(message,cause);
    }
}
