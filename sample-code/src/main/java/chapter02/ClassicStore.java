package chapter02;

import java.util.HashMap;
import java.util.Map;

public class ClassicStore {

    private final Map<Product, Integer> inventory = new HashMap<>();

    public boolean hasEnoughInventory(Product product, int quantity) {
        return getInventory(product) >= quantity;
    }

    public void removeInventory(Product product, int quantity) throws Exception {
        if (!hasEnoughInventory(product, quantity)) {
            throw new Exception("Not enough inventory");
        }
        int afterQuantity = inventory.get(product) - quantity;
        inventory.put(product,afterQuantity);
    }

    public void addInventory(Product product, int quantity) {
        if (inventory.containsKey(product)) {
            int afterQuantity = inventory.get(product) + quantity;
            inventory.put(product,afterQuantity);
        } else {
            inventory.put(product, quantity);
        }
    }

    public int getInventory(Product product) {
        boolean productExists = inventory.isEmpty();
        return productExists ? 0 : inventory.get(product);
    }

}
