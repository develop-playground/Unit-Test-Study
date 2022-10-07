package chapter03.fixture;

import chapter03.aaa.Customer;
import chapter03.aaa.Product;
import chapter03.aaa.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerTests {

    private Store _store;
    private Customer _sut;

    @BeforeEach
    public void setup() {
        _store = new Store();
        _store.addInventory(Product.Shampoo, 10);
        _sut = new Customer();
    }

    @Test
    public void purchaseSucceedsWhenEnoughInventory() throws Exception {
        boolean success = _sut.purchase(_store, Product.Shampoo, 5);
        Assertions.assertTrue(success);
        Assertions.assertEquals(5,_store.getInventory(Product.Shampoo));
    }

    @Test
    public void purchaseFailsWhenNotEnoughInventory() throws Exception {
        boolean success = _sut.purchase(_store, Product.Shampoo, 15);
        Assertions.assertFalse(success);
        Assertions.assertEquals(10,_store.getInventory(Product.Shampoo));
    }

}
