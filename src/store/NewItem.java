package store;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NewItem extends Item {
    private final String calcMethodName;

    public NewItem(String name, int sale_in, int quality, String calcMethodName) {
        super(name, sale_in, quality);
        this.calcMethodName = calcMethodName;
    }

    public void updateQuality() {
        try {
            Method method = Store.class.getMethod(this.calcMethodName, int.class, int.class);
            int[] values = (int[]) method.invoke(null, this.sale_in, this.quality);
            this.sale_in = values[0];
            this.quality = values[1];
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
            ex.printStackTrace();
        }

    }
}
