package flower;

/**
 * The {@code Normal} class represents a typical type of flower.
 * It extends the {@code Flower} class and represents flowers with regular behavior regarding cost and freshness.
 */
public class Normal extends Flower {

    /**
     * Constructs a {@code Normal} flower with the specified cost, length, and freshness level.
     *
     * @param cost           the cost of the flower
     * @param length         the length of the flower
     * @param freshnessLevel the freshness level of the flower
     */
    public Normal(double cost, double length, int freshnessLevel) {
        super(cost, length, freshnessLevel);
    }
}