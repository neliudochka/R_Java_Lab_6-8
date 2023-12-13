/**
 * The {@code BouquetException} class represents an exception specific to the Bouquet class operations.
 * It extends the {@code RuntimeException} class.
 */
public class BouquetException extends RuntimeException {

    /**
     * Constructs a new BouquetException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     */
    public BouquetException(String message) {
        super(message);
    }
}
