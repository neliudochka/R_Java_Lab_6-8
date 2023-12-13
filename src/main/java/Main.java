import accessory.Band;
import accessory.Cellophane;
import flower.Evergreen;
import flower.FlowerException;
import flower.Normal;
import flower.Tricky;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Normal normal = new Normal(20, 12, 1);
            Tricky tricky = new Tricky(8, 10, 2);
            Evergreen evergreen = new Evergreen(11, 15);

            Band band = new Band(12);
            Cellophane cellophane = new Cellophane(20);

            Bouquet bouquet = new Bouquet();
            bouquet.addFlower(List.of(normal, tricky,evergreen));
            bouquet.addAccessory(List.of(band, cellophane));

            System.out.println(bouquet);
            bouquet.sort();
            System.out.println(bouquet);

            System.out.println(bouquet.findFlowerByRangeOfLengths(2, 11));
        } catch (FlowerException fe) {
            System.out.println("FlowerException: " + fe.getMessage());
        } catch (BouquetException be) {
            System.out.println("BouquetException: " + be.getMessage());
        } catch (RuntimeException re) {
            System.out.println("RuntimeException: " + re.getMessage());
        }
    }
}
