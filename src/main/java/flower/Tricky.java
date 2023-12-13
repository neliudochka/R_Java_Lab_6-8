package flower;

/**
 * Tricky flower cost is always multiplied by two.
 */
public class Tricky extends Flower{
    /**
     * Constructs a Tricky flower with the specified cost, length, and freshness.
     *
     * @param cost      the cost of the flower
     * @param length    the length of the flower
     * @param freshness the freshness level of the flower
     */
    public Tricky(double cost, double length, int freshness) {
        super(cost, length, freshness);
    }

    /**
     * Retrieves the cost of the tricky flower, doubling the calculated cost of the base flower.
     *
     * @return the cost of the tricky flower, which is twice the base cost
     */
    @Override
    public double getCost() {
        return super.getCost() * 2;
    }
}
