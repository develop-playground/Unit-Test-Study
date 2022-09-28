package chapter02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClassicStyleTest {

    @Test
    @DisplayName("재고 내에서 구매요청 성공 테스트")
    public void purchaseSucceedsWhenEnoughInventory() throws Exception {
        // Arrange, 준비
        Store store = new Store();
        store.addInventory(Product.Shampoo, 10);
        Customer customer = new Customer();

        // Act, 실행
        boolean success = customer.purchase(store, Product.Shampoo, 5);

        // Assert, 검증
        Assertions.assertTrue(success);
        Assertions.assertEquals(5, store.getInventory(Product.Shampoo));
    }

    @Test
    @DisplayName("재고보다 많은 구매요청 실패 테스트")
    public void purchaseFailsWhenNotEnoughInventory() throws Exception {
        // Arrange, 준비
        Store store = new Store();
        store.addInventory(Product.Shampoo, 10);
        Customer customer = new Customer();

        // Act, 실행
        boolean success = customer.purchase(store, Product.Shampoo, 15);

        // Assert, 검증
        Assertions.assertFalse(success);
        Assertions.assertEquals(10, store.getInventory(Product.Shampoo));
    }

}
