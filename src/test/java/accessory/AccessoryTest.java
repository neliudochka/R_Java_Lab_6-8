package accessory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccessoryTest {
    public static class AccessoryTestStub extends Accessory {
        public AccessoryTestStub(double cost) {
            super(cost);
        }
    }

    //constructor
    @Test
    void constructor_ValidCost_AccessoryCreated() {
        double cost = 15.0;
        Accessory accessory = new AccessoryTestStub(cost);
        assertNotNull(accessory);
        assertEquals(cost, accessory.getCost());
    }

    @Test
    void constructor_ZeroCost_ExceptionThrown() {
        assertThrows(RuntimeException.class,
                () -> new AccessoryTestStub(0));
    }

    @Test
    void constructor_NegativeCost_ExceptionThrown() {
        assertThrows(RuntimeException.class,
                () -> new AccessoryTestStub(-5));
    }

    //getCost
    @Test
    void getCost_ReturnsCorrectCost() {
        double cost = 20.5;
        Accessory accessory = new AccessoryTestStub(cost);
        double got = accessory.getCost();
        assertEquals(cost, got);
    }

    //toString
    @Test
    void toString_ReturnsExpectedFormat() {
        double cost = 12.4;
        Accessory accessory = new AccessoryTestStub(cost);
        String result = accessory.toString();
        String expected = "Class: AccessoryTestStub\n" +
                "cost: " + cost + "\n";
        assertEquals(expected, result);
    }
}