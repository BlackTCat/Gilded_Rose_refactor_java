package test;

import store.NewItem;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NewItemTest {

    @org.junit.jupiter.api.Test
    void testUpdateQuality() {
        NewItem item = new NewItem("Default Item", 10, 40, "calcQualityDefault");
        item.updateQuality();
        int[] m = {9, 39};
        int[] result = {item.sale_in, item.quality};
        assertEquals(m[0], result[0]);
        assertEquals(m[1], result[1]);
    }
}
