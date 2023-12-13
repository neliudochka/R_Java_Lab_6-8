package accessory;

/**
 * Abstract class representing an accessory that can be included in a bouquet.
 * Any specific accessory type sho  uld extend this class to define its properties.
 */
abstract public class Accessory {

    private double cost;

    /**
     * Constructs an accessory with a specified cost.
     *
     * @param cost the cost of the accessory
     * @throws RuntimeException if the cost is less than or equal to 0
     */
    public Accessory(double cost) {
        setCost(cost);
    }

    /**
     * Sets the cost of the accessory.
     *
     * @param cost the cost to set
     * @throws RuntimeException if the cost is less than or equal to 0
     */
    private void setCost(double cost) {
        if (cost <= 0) {
            throw new RuntimeException("Cost can't be <= 0");
        }
        this.cost = cost;
    }

    /**
     * Retrieves the cost of the accessory.
     *
     * @return the cost of the accessory
     */
    public double getCost() {
        return cost;
    }

    /**
     * Returns a string representation of the accessory.
     *
     * @return a string representation including the class name and cost of the accessory
     */
    @Override
    public String toString() {
        return "Class: " + this.getClass().getSimpleName() + "\n" +
                "cost: " + getCost() + "\n";
    }
}
