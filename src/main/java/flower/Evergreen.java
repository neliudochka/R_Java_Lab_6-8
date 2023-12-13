package flower;

/**
 * Evergreen flowers picking date do not affect freshness.
 */
public class Evergreen extends Flower{
    /**
     * Constructs an Evergreen flower with the specified cost, length, and sets freshness to 0.
     *
     * @param cost   the cost of the flower
     * @param length the length of the flower
     */
    public Evergreen(double cost, double length) {
        super(cost, length, 0);
    }

    /**
     * Evergreen flowers' freshness level remains constant and is not affected by decrease operations.
     */
    @Override
    public void decreaseFreshnessLevel() {}
}
