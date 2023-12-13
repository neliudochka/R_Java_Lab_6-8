package accessory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellophaneTest {
    //only test constructor, because other methods are the same as parent's class

    @Test
    void constructor_ValidCost_CellophaneCreated() {
        float cost = 2.0f;
        Cellophane cellophane = new Cellophane(cost);
        assertNotNull(cellophane);
        assertEquals(cost, cellophane.getCost());
    }

    @Test
    void constructor_ZeroCost_ExceptionThrown() {
        assertThrows(RuntimeException.class, () -> new Cellophane(0));
    }

    @Test
    void constructor_NegativeCost_ExceptionThrown() {
        assertThrows(RuntimeException.class, () -> new Cellophane(-5));
    }
}
