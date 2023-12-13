package accessory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BandTest {
    //only test constructor, because other methods are the same as parent's class
    @Test
    void constructor_ValidCost_BandCreated() {
        float cost = 25.0f;
        Band band = new Band(cost);
        assertNotNull(band);
        assertEquals(cost, band.getCost());
    }

    @Test
    void constructor_ZeroCost_ExceptionThrown() {
        assertThrows(RuntimeException.class, () -> new Band(0));
    }


    @Test
    void constructor_NegativeCost_ExceptionThrown() {
        assertThrows(RuntimeException.class, () -> new Band(-5));
    }
}
