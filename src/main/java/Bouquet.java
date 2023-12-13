import FlowerSet.FlowerSet;
import accessory.Accessory;
import flower.Flower;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * The {@code Bouquet} class represents a collection of flowers and accessories.
 */
public class Bouquet {
    public Collection<Flower> flowers = new FlowerSet();
    public List<Accessory> accessories = new ArrayList<>();

    /**
     * Constructs a bouquet with specified flowers and accessories.
     *
     * @param flowers     the list of flowers to be added to the bouquet
     * @param accessories the list of accessories to be added to the bouquet
     */
    public Bouquet(@NotNull List<Flower> flowers, @NotNull List<Accessory> accessories) {
        addFlower(flowers);
        addAccessory(accessories);
    }

    /**
     * Constructs an empty bouquet.
     */
    public Bouquet() {
    }


    /**
     * Adds a list of flowers to the bouquet.
     *
     * @param flowers the list of flowers to be added
     * @throws BouquetException if the provided list of flowers is empty
     */
    public void addFlower(@NotNull List<Flower> flowers) {
        if(flowers.isEmpty())
            throw new BouquetException("Can't add empty array of flowers!");
        this.flowers.addAll(flowers);
    }

    /**
     * Adds a single flower to the bouquet.
     *
     * @param flower the flower to add
     */
    public void addFlower(Flower flower) {
        this.flowers.add(flower);
    }

    /**
     * Adds a list of accessories to the bouquet.
     *
     * @param accessories the list of accessories to add
     * @throws BouquetException if the provided list is empty
     */
    public void addAccessory(@NotNull List<Accessory> accessories) {
        if(accessories.isEmpty())
            throw new BouquetException("Can't add empty array of accessories!");
        this.accessories.addAll(accessories);
    }

    /**
     * Adds a single accessory to the bouquet.
     *
     * @param accessory the accessory to add
     */
    public void addAccessory(Accessory accessory) {
        this.accessories.add(accessory);
    }

    /**
     * Calculates the total cost of the bouquet.
     *
     * @return the total cost of the bouquet
     */
    public double calculateCost() {
        double cf = flowers.stream().mapToDouble(Flower::getCost).sum();
        double ca = accessories.stream().mapToDouble(Accessory::getCost).sum();
        return cf + ca;
    }

    /**
     * Finds a flower within a specified range of lengths.
     *
     * @param min the minimum length
     * @param max the maximum length
     * @return a flower within the specified length range
     * @throws BouquetException        if the minimum value is greater than the maximum value
     * @throws BouquetException        if no flower is found within the specified range
     */
    public Flower findFlowerByRangeOfLengths(double min, double max) {
        if (min > max) {
            throw new BouquetException("Min value must be smaller than max");
        }

        Flower foundFlower = flowers.stream()
                .filter(f -> f.getLength() >= min && f.getLength() <= max)
                .findFirst()
                .orElse(null);

        if (foundFlower == null) {
            throw new BouquetException("No flower found within the specified length range");
        }

        return foundFlower;
    }

    /**
     * Returns a string representation of the bouquet.
     *
     * @return a string containing information about the bouquet
     */
    @Override
    public String toString() {
        return "------------------" + "\n" +
                "Class: " + this.getClass().getSimpleName() + "\n" +
                ". . . . . . ." + "\n" +
                "flowers: \n" + this.flowers + "\n" +
                ". . . . . . ." + "\n" +
                "accessories: \n" + this.accessories + "\n" +
                ". . . . . . ." + "\n" +
                "bouquet cost: " + calculateCost() + "\n" +
                "------------------" + "\n";
    }

    /**
     * Sorts the flowers in the bouquet.
     */
    public void sort() {
        //Collections.sort(flowers);
        List<Flower> flowerList = new ArrayList<>(flowers);
        Collections.sort(flowerList);
        flowers = new FlowerSet(flowerList);
    }
}
