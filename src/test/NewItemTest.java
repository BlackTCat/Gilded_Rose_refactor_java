package test;

import store.NewItem;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NewItemTest {

    @org.junit.jupiter.api.Test
    void testUpdateQualityDefaultItem() {
        NewItem item = new NewItem("Default Item", 10, 40, "calcQualityDefault");
        item.updateQuality();
        int[] expected = {9, 39};
        int[] result = {item.sale_in, item.quality};
        assertEquals(expected[0], result[0]);
        assertEquals(expected[1], result[1]);
    }

    @org.junit.jupiter.api.Test
    void testUpdateQualitySulfaras() {
        NewItem item = new NewItem("Sulfaras", 10, 80, "calcQualityStable");
        for(int i=0; i<10; i++) {
            item.updateQuality();
        }
        int[] expected = {10, 80};
        int[] result = {item.sale_in, item.quality};
        assertEquals(expected[0], result[0]);
        assertEquals(expected[1], result[1]);

    }
}
