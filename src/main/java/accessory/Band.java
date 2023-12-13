package accessory;

/**
 * The {@code Band} class represents a band accessory that extends the {@code Accessory} class.
 * It sets the cost of the band accessory upon creation using the provided cost value.
 */
public class Band extends Accessory {

    /**
     * Constructs a {@code Band} accessory with the specified cost.
     *
     * @param cost the cost of the band accessory
     */
    public Band(float cost) {
        super(cost);
    }
}
