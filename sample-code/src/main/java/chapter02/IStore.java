package chapter02;

public interface IStore {
    public boolean hasEnoughInventory(Product product, int quantity);
    public void removeInventory(Product product, int quantity) throws Exception;
    public void addInventory(Product product, int quantity);
    public int getInventory(Product product);
}
