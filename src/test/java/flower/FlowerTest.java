package flower;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlowerTest {

    public static class FlowerStub extends Flower {
        public FlowerStub(double cost, double length, int freshnessLevel) {
            super(cost, length, freshnessLevel);
        }
    }

    //constructor
    @Test
    void constructor_Valid_Input() {
        final FlowerStub[] flower = new FlowerStub[1];
        assertDoesNotThrow(() -> {
            flower[0] = new FlowerStub(12, 13, 0);
        });

        assertEquals(12, flower[0].getCost());
        assertEquals(13, flower[0].getLength());
        assertEquals(0, flower[0].getFreshnessLevel());
    }

    @Test
    void constructor_InvalidCost_ThrowsFlowerException() {
        assertThrows(FlowerException.class,
                () -> new FlowerStub(-5, 5, 3));
    }

    @Test
    void constructor_InvalidLength_ThrowsFlowerException() {
        assertThrows(FlowerException.class,
                () -> new FlowerStub(10, -5, 3));
    }

    @Test
    void constructor_InvalidFreshnessLevel_ThrowsFlowerException() {
        assertThrows(FlowerException.class,
                () -> new FlowerStub(10, 5, -3));
    }

    //freshness
    @Test
    void getFreshnessLevel_CorrectValue() {
        FlowerStub flower = new FlowerStub(10, 5, 3);
        assertEquals(3, flower.getFreshnessLevel());
    }

    @Test
    void decreaseFreshnessLevel_DecreasesCorrectly() {
        FlowerStub flower = new FlowerStub(10, 5, 3);
        flower.decreaseFreshnessLevel();
        assertEquals(4, flower.getFreshnessLevel());
    }

    //cost
    @Test
    void setCost_ValidCost_CostSetCorrectly() {
        FlowerStub flower = new FlowerStub(10, 5, 0);
        assertDoesNotThrow(() -> {flower.setCost(20);});
        assertEquals(20, flower.getCost());
    }

    @Test
    void setCost_InvalidCost_ThrowsException() {
        FlowerStub flower = new FlowerStub(10, 5, 3);
        assertThrows(FlowerException.class, () -> flower.setCost(0));
        assertThrows(FlowerException.class, () -> flower.setCost(-5));
    }

    @Test
    void getCost_ValidCostAndFreshness_CalculatesCorrectly() {
        FlowerStub flower = new FlowerStub(10, 5, 3);
        assertEquals(9.7, flower.getCost());
    }

    @Test
    void getCost_ZeroFreshness_CalculatesCorrectly() {
        FlowerStub flower = new FlowerStub(20, 5, 0);
        assertEquals(20.0, flower.getCost());
    }

    @Test
    void getCost_MaxFreshness_CalculatesCorrectly() {
        FlowerStub flower = new FlowerStub(15, 6, 100);
        assertEquals(0.0, flower.getCost());
    }

    @Test
    void getCost_NegativeStartingCost_ThrowsException() {
        assertThrows(FlowerException.class, () -> {
            new FlowerStub(-5, 4, 10).getCost();
        });
    }

    @Test
    void getCost_UnfreshFlower_CostIsZeroANdNotNegative() {
        FlowerStub flower = new FlowerStub(15, 6, 103);
        assertEquals(0.0, flower.getCost());
    }

    //len
    @Test
    void getLength_ValidLength_ReturnsLength() {
        FlowerStub flower = new FlowerStub(20, 5.5, 30);
        assertEquals(5.5, flower.getLength());
    }

    @Test
    void getLength_ZeroLength_ThrowsException() {
        assertThrows(FlowerException.class, () -> {
            new FlowerStub(15, 0, 40).getLength();
        });
    }

    @Test
    void getLength_NegativeLength_ThrowsException() {
        assertThrows(FlowerException.class, () -> {
            new FlowerStub(10, -3.2, 20).getLength();
        });
    }

    //compareTo
    @Test
    void compareTo_FreshnessLevelsEqual_ReturnsZero() {
        FlowerStub flower1 = new FlowerStub(20, 5.5, 30);
        FlowerStub flower2 = new FlowerStub(15, 3.5, 30);
        assertEquals(0, flower1.compareTo(flower2));
    }

    @Test
    void compareTo_ThisFreshnessGreater_ReturnsOne() {
        FlowerStub flower1 = new FlowerStub(20, 5.5, 40);
        FlowerStub flower2 = new FlowerStub(15, 3.5, 30);
        assertEquals(1, flower1.compareTo(flower2));
    }

    @Test
    void compareTo_FlowerFreshnessGreater_ReturnsNegativeOne() {
        FlowerStub flower1 = new FlowerStub(20, 5.5, 20);
        FlowerStub flower2 = new FlowerStub(15, 3.5, 30);
        assertEquals(-1, flower1.compareTo(flower2));
    }

    //toString
    @Test
    void toString_Flower_ReturnsCorrectStringRepresentation() {
        FlowerStub flower = new FlowerStub(20, 5.5, 30);
        //20-20*0.01*30 = 14
        String expected = "Class: FlowerStub\n" +
                "freshness level: 30\n" +
                "length: 5.5\n" +
                "cost: 14.0\n";
        assertEquals(expected, flower.toString());
    }
}