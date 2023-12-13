package flower;

/**
 * The {@code Flower} class is an abstract class representing a flower.
 * It implements the {@code Comparable} interface for comparison based on freshness levels.
 */
abstract public class Flower implements Comparable<Flower> {
    private int freshnessLevel;
    private double startingCost;
    private double length;

    /**
     * Constructs a {@code Flower} with the specified cost, length, and freshness level.
     *
     * @param cost           the cost of the flower
     * @param length         the length of the flower
     * @param freshnessLevel the freshness level of the flower
     * @throws FlowerException if freshness, cost, or length values are invalid
     */
    protected Flower(double cost, double length, int freshnessLevel) {
        setCost(cost);
        setLength(length);
        setFreshnessLevel(freshnessLevel);
    }

    /**
     * Sets the freshness level of the flower.
     *
     * @param freshnessLevel the freshness level to be set
     * @throws FlowerException if the provided freshness level is less than 0
     */
    private void setFreshnessLevel(int freshnessLevel) {
        if (freshnessLevel < 0) {
            throw new FlowerException("Freshness must be int >= 0. Where 0 corresponds to the max freshness.");
        }
        this.freshnessLevel = freshnessLevel;
    }

    /**
     * Retrieves the freshness level of the flower.
     *
     * @return the freshness level of the flower
     */
    public int getFreshnessLevel() {
        return this.freshnessLevel;
    }
    /**
     * Decreases the freshness level of the flower.
     */
    public void decreaseFreshnessLevel() {
        this.freshnessLevel++;
    }

    /**
     * Sets the cost of the flower.
     *
     * @param cost the cost of the flower
     * @throws FlowerException if the provided cost is less than or equal to 0
     */
    public void setCost(double cost) {
        if (cost <= 0) {
            throw new FlowerException("Cost can't be <= 0");
        }
        this.startingCost = cost;
    }

    /**
     * Retrieves the cost of the flower, considering the freshness level.
     *
     * @return the cost of the flower
     */
    public double getCost() {
        double curCost = startingCost - startingCost * 0.01 * freshnessLevel;
        return curCost >= 0 ? curCost : 0;
    }

    /**
     * Sets the length of the flower.
     *
     * @param length the length of the flower
     * @throws FlowerException if the provided length is less than or equal to 0
     */
    private void setLength(double length) {
        if (length <= 0) {
            throw new FlowerException("Length can't be <= 0");
        }
        this.length = length;
    }

    /**
     * Retrieves the length of the flower.
     *
     * @return the length of the flower
     */
    public double getLength() {
        return length;
    }

    /**
     * Compares the freshness levels of flowers.
     *
     * @param flower the flower to compare freshness levels with
     * @return a negative integer, zero, or a positive integer as this flower's
     * freshness level is less than, equal to, or greater than the specified flower
     */
    @Override
    public int compareTo(Flower flower) {
        if (this.freshnessLevel > flower.freshnessLevel) return 1;
        if (this.freshnessLevel < flower.freshnessLevel) return -1;
        return 0;
    }

    /**
     * Returns a string representation of the flower.
     *
     * @return a string containing the class name, freshness level, length, and cost of the flower
     */
    @Override
    public String toString() {
        return "Class: " + this.getClass().getSimpleName() + "\n" +
                "freshness level: " + this.freshnessLevel + "\n" +
                "length: " + getLength() + "\n" +
                "cost: " + getCost() + "\n";
    }
}
