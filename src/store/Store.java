package store;

import java.util.ArrayList;

public class Store extends ArrayList<NewItem> {
    public static int MIN_QUALITY = 0;
    public static int MAX_QUALITY = 50;
    public static int STABLE_QUALITY = 80;

    private String name;

    public Store(String name) {
        super();
        this.name = name;
    }

    public void showStore() {
        for (NewItem item: this) {
            System.out.println(item);
        }
    }

    public void updateQuality() {
        for (NewItem item: this) {
            item.updateQuality();
        }
    }

    public static int day_check(int day) {
        return (day < 0)? 0: day;
    }

    public static int quality_check(int qu) {
        if(qu < Store.MIN_QUALITY) {
            return Store.MIN_QUALITY;
        }
        if(qu <= Store.MAX_QUALITY) {
            return qu;
        } else {
            return Store.MAX_QUALITY;
        }
    }

    public static int[] calcQualityDefault(int day, int quality) {
        if(day > 0) {
            return new int[]{day_check(--day), quality_check(--quality)};
        } else {
            return new int[]{day_check(--day), quality_check(quality - 2)};
        }
    }

    public static int[] calcQualityIncrease(int day, int quality) {
        return new int[]{day_check(--day), quality_check(++quality)};
    }

    public static int[] calcQualityStable(int day, int quality) {
        return new int[]{day_check(day), Store.STABLE_QUALITY};
    }

    public static int[] calcQualityDefaultFast(int day, int quality) {
        if(day > 0) {
            return new int[]{day_check(--day), quality_check(quality - 2)};
        } else {
            return new int[]{day_check(--day), quality_check(quality - 4)};
        }
    }

    public static void main(String[] args) {
        Store store = new Store("Wonder Store");
        store.add(new NewItem("Default Item", 10, 40, "calcQualityDefault"));
        store.add(new NewItem("Aged Brie", 10, 40, "calcQualityIncrease"));
        store.add(new NewItem("Sulfaras", 10, 80, "calcQualityStable"));
        store.add(new NewItem("Conjured", 10, 40, "calcQualityDefaultFast"));

        System.out.printf("Store << %s >> %n", store.name);
        for(int i=1; i<20; i++) {
            System.out.printf(">>>> DAY: %d %n", i);
            store.updateQuality();
            store.showStore();
        }
    }
}
