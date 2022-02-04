package store;

public class Item {
    public String name;
    public int sale_in;
    public int quality;

    public Item(String name, int sale_in, int quality) {
        this.name = name;
        this.sale_in = sale_in;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return String.format("  %s day_exp: %d quality: %d", this.name, this.sale_in, this.quality);
    }
}
