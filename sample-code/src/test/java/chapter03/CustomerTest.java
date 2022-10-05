package chapter03;

import chapter02.ClassicCustomer;
import chapter02.ClassicStore;
import chapter02.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    /*
    * 한 줄로 된 실행 구절
    * @byeongsoon
     */

    @Test
    public void purchaseSucceedsWhenEnoughInventory1() throws Exception {
        // Arrange or Given
        ClassicStore store = new ClassicStore();
        store.addInventory(chapter02.Product.Shampoo, 10);
        ClassicCustomer customer = new ClassicCustomer();

        // Act or When
        boolean success = customer.purchase(store, chapter02.Product.Shampoo, 5);

        // Assert or Then
        Assertions.assertTrue(success);
        Assertions.assertEquals(5, store.getInventory(chapter02.Product.Shampoo));
    }

    /*
     * 두 줄로 된 실행 구절
     * @byeongsoon
     */
    @Test
    public void purchaseSucceedsWhenEnoughInventory2() throws Exception {
        // Arrange or Given
        ClassicStore store = new ClassicStore();
        store.addInventory(chapter02.Product.Shampoo, 10);
        ClassicCustomer customer = new ClassicCustomer();

        // Act or When
        boolean success = customer.purchase(store, chapter02.Product.Shampoo, 5);
        store.removeInventory(Product.Shampoo, 5);

        // Assert or Then
        Assertions.assertTrue(success);
        Assertions.assertEquals(5, store.getInventory(chapter02.Product.Shampoo));
    }


}
