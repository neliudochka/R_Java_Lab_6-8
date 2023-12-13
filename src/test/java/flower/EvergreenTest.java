package flower;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//test the behavior that differ from Flower
class EvergreenTest {
    @Test
    void evergreen_DecreaseFreshness_CheckFreshnessLevel() {
        double cost = 10.0;
        double length = 5.0;

        Flower evergreen = new Evergreen(cost, length);

        evergreen.decreaseFreshnessLevel();

        assertEquals(0, evergreen.getFreshnessLevel());
    }
}