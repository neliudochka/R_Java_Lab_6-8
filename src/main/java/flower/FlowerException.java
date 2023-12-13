package flower;
/**
 * Custom exception class for handling flower-related exceptions.
 * Extends RuntimeException.
 */
public class FlowerException extends RuntimeException {
    /**
     * Constructs a new FlowerException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     */
    public FlowerException(String message) {
        super(message);
    }
}
