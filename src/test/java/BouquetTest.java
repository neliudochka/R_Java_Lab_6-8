import accessory.Accessory;
import accessory.AccessoryTest;
import flower.Flower;
import flower.FlowerTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BouquetTest {
    //constructor
    @Test
    void constructor_ValidInput_CreatesBouquet() {
        List<Flower> flowers = new ArrayList<>();
        List<Accessory> accessories = new ArrayList<>();
        flowers.add(new FlowerTest.FlowerStub(10, 5, 3));
        accessories.add(new AccessoryTest.AccessoryTestStub(34));
        assertDoesNotThrow(() -> new Bouquet(flowers, accessories));
    }

    @Test
    void constructor_EmptyFlowers_ThrowsException() {
        List<Flower> flowers = new ArrayList<>();
        List<Accessory> accessories = new ArrayList<>();
        assertThrows(BouquetException.class, () -> new Bouquet(flowers, accessories));
    }

    @Test
    void constructor_EmptyAccessories_ThrowsException() {
        List<Flower> flowers = new ArrayList<>();
        List<Accessory> accessories = new ArrayList<>();
        flowers.add(new FlowerTest.FlowerStub(10, 5, 3));
        assertThrows(BouquetException.class, () -> new Bouquet(flowers, accessories));
    }

    //addFlower(c)
    @Test
    void addFlower_ValidInput_AddsFlower() {
        Bouquet bouquet = new Bouquet();
        Flower f1 = new FlowerTest.FlowerStub(10, 5, 3);
        Flower f2 = new FlowerTest.FlowerStub(10, 5, 3);

        assertDoesNotThrow(() -> bouquet.addFlower(List.of(f1, f2)));
        assertTrue(bouquet.flowers.containsAll(List.of(f1, f2)));
    }

    @Test
    void addFlower_EmptyFlowerList_ThrowsException() {
        Bouquet bouquet = new Bouquet();
        assertThrows(BouquetException.class, () -> bouquet.addFlower(new ArrayList<>()));
    }

    //addFlower 1
    @Test
    void addFlower_OneFlower_AddsFlower() {
        Bouquet bouquet = new Bouquet();
        Flower flower = new FlowerTest.FlowerStub(10, 5, 3);

        assertDoesNotThrow(() -> bouquet.addFlower(flower));
        assertTrue(bouquet.flowers.contains(flower));
    }

    //addAccessory
    @Test
    void addAccessory_AccessoryList_AddsAccessories() {
        Bouquet bouquet = new Bouquet();
        List<Accessory> accessories = new ArrayList<>();
        accessories.add(new AccessoryTest.AccessoryTestStub(20));
        accessories.add(new AccessoryTest.AccessoryTestStub(30));

        assertDoesNotThrow(() -> bouquet.addAccessory(accessories));
        assertTrue(bouquet.accessories.containsAll(accessories));
    }

    @Test
    void addAccessory_EmptyAccessoryList_ThrowsException() {
        Bouquet bouquet = new Bouquet();
        List<Accessory> accessories = new ArrayList<>();

        assertThrows(BouquetException.class, () -> bouquet.addAccessory(accessories));
        assertTrue(bouquet.accessories.isEmpty());
    }

    //1
    @Test
    void addAccessory_OneAccessory_AddsToAccessories() {
        Bouquet bouquet = new Bouquet();
        Accessory accessory = new AccessoryTest.AccessoryTestStub(20);

        assertDoesNotThrow(() -> bouquet.addAccessory(accessory));
        assertTrue(bouquet.accessories.contains(accessory));
    }

    //calculateCost
    @Test
    void calculateCost_EmptyBouquet_ReturnsZero() {
        Bouquet bouquet = new Bouquet();
        double cost = bouquet.calculateCost();
        assertEquals(0, cost);
    }

    @Test
    void calculateCost_BouquetWithItems_ReturnsTotalCost() {
        List<Flower> flowers = new ArrayList<>();
        List<Accessory> accessories = new ArrayList<>();

        flowers.add(new FlowerTest.FlowerStub(10, 5, 0));
        flowers.add(new FlowerTest.FlowerStub(15, 6, 0));

        accessories.add(new AccessoryTest.AccessoryTestStub(34));
        accessories.add(new AccessoryTest.AccessoryTestStub(20));

        Bouquet bouquet = new Bouquet(flowers, accessories);
        double cost = bouquet.calculateCost();
        assertEquals(79, cost);
    }


    @Test
    void calculateCost_BouquetWithNotFreshFlowers_ReturnsTotalCost() {
        List<Flower> flowers = new ArrayList<>();
        List<Accessory> accessories = new ArrayList<>();

        flowers.add(new FlowerTest.FlowerStub(10, 5, 2));
        flowers.add(new FlowerTest.FlowerStub(15, 6, 3));

        accessories.add(new AccessoryTest.AccessoryTestStub(34));
        accessories.add(new AccessoryTest.AccessoryTestStub(20));

        //cost = 10-10*0.01*2+15-15*0.01*3+34+20
        Bouquet bouquet = new Bouquet(flowers, accessories);
        double cost = bouquet.calculateCost();
        assertEquals(78.35, cost);
    }

    //findFlowerByRangeOfLengths
    @Test
    void findFlowerByRangeOfLengths_ValidRange_ReturnsFlower() {
        List<Flower> flowers = new ArrayList<>();
        Flower rose = new FlowerTest.FlowerStub(10, 5, 3);
        Flower lily = new FlowerTest.FlowerStub(15, 7, 4);
        flowers.add(rose);
        flowers.add(lily);

        List<Accessory> accessories = new ArrayList<>();
        accessories.add(new AccessoryTest.AccessoryTestStub(34));
        accessories.add(new AccessoryTest.AccessoryTestStub(20));

        Bouquet bouquet = new Bouquet(flowers, accessories);

        Flower foundFlower = bouquet.findFlowerByRangeOfLengths(4, 6);

        assertNotNull(foundFlower);
        assertEquals(rose, foundFlower);
    }

    @Test
    void findFlowerByRangeOfLengths_InvalidRange_ThrowsException() {
        List<Flower> flowers = new ArrayList<>();
        Flower rose = new FlowerTest.FlowerStub(10, 5, 3);
        flowers.add(rose);

        List<Accessory> accessories = new ArrayList<>();
        accessories.add(new AccessoryTest.AccessoryTestStub(34));
        accessories.add(new AccessoryTest.AccessoryTestStub(20));

        Bouquet bouquet = new Bouquet(flowers, accessories);

        assertThrows(BouquetException.class, () -> bouquet.findFlowerByRangeOfLengths(6, 4));
    }

    @Test
    void findFlowerByRangeOfLengths_NoFlowerInRange_ThrowsException() {
        List<Flower> flowers = new ArrayList<>();
        Flower rose = new FlowerTest.FlowerStub(10, 5, 3);
        flowers.add(rose);

        List<Accessory> accessories = new ArrayList<>();
        accessories.add(new AccessoryTest.AccessoryTestStub(34));
        accessories.add(new AccessoryTest.AccessoryTestStub(20));

        Bouquet bouquet = new Bouquet(flowers, accessories);

        assertThrows(BouquetException.class, () -> bouquet.findFlowerByRangeOfLengths(20, 25));
    }

    //toString
    @Test
    void toString_FullBouquet_String() {
        List<Flower> flowers = new ArrayList<>();
        Flower rose = new FlowerTest.FlowerStub(10, 5, 3);
        flowers.add(rose);

        List<Accessory> accessories = new ArrayList<>();
        accessories.add(new AccessoryTest.AccessoryTestStub(34));
        accessories.add(new AccessoryTest.AccessoryTestStub(20));

        Bouquet bouquet = new Bouquet(flowers, accessories);

        String expectedString = "------------------\n" +
                "Class: Bouquet\n" +
                ". . . . . . .\n" +
                "flowers: \n" + bouquet.flowers + "\n" +
                ". . . . . . .\n" +
                "accessories: \n" + bouquet.accessories + "\n" +
                ". . . . . . .\n" +
                "bouquet cost: " + bouquet.calculateCost() + "\n" +
                "------------------\n";

        assertEquals(expectedString, bouquet.toString());
    }

    //sort
    @Test
    void testSort() {
        List<Accessory> accessories = new ArrayList<>();
        accessories.add(new AccessoryTest.AccessoryTestStub(34));

        Flower help = new FlowerTest.FlowerStub(1, 1, 3);
        Flower me = new FlowerTest.FlowerStub(1,1,0);
        Flower please = new FlowerTest.FlowerStub(1,1,2);

        Bouquet testBouquet = new Bouquet(Arrays.asList(help, me, please), accessories);

        List<Flower> initialFlowerOrder = new ArrayList<>(testBouquet.flowers);
        assertEquals(help, initialFlowerOrder.get(0));
        assertEquals(me, initialFlowerOrder.get(1));
        assertEquals(please, initialFlowerOrder.get(2));

        testBouquet.sort();

        List<Flower> sortedFlowerOrder = new ArrayList<>(testBouquet.flowers);
        assertEquals(me, sortedFlowerOrder.get(0));
        assertEquals(please, sortedFlowerOrder.get(1));
        assertEquals(help, sortedFlowerOrder.get(2));
    }

}