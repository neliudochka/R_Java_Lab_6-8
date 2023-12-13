package flower;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NormalTest {
    @Test
    void constructor_ValidInput_CreatesFlower() {
        double cost = 10.0;
        double length = 5.1;
        int freshness = 0;

        Flower normal = new Normal(cost, length, freshness);

        assertEquals(freshness, normal.getFreshnessLevel());
        assertEquals(cost, normal.getCost());
        assertEquals(length, normal.getLength());

        normal.decreaseFreshnessLevel();
        assertEquals(freshness+1, normal.getFreshnessLevel());
        assertEquals(cost-cost*0.01*(freshness+1), normal.getCost());

    }
}