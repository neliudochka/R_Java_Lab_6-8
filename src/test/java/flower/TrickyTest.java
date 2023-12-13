package flower;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrickyTest {

    @Test
    void getCost_ZeroFreshness_DoubleCost() {
        double baseCost = 15.0;
        double length = 7.0;
        int zeroFreshness = 0;
        Tricky trickyFlower = new Tricky(baseCost, length, zeroFreshness);
        double expectedCost = baseCost * 2;
        assertEquals(expectedCost, trickyFlower.getCost());
    }


    @Test
    void getCost_FreshnessMoreThanZero_DoubleCost() {
        double baseCost = 10.0;
        double length = 5.0;
        int freshness = 3;
        Tricky trickyFlower = new Tricky(baseCost, length, freshness);
        double expectedCost = (baseCost-baseCost*0.01*(freshness)) * 2;
        assertEquals(expectedCost, trickyFlower.getCost());
    }

}
