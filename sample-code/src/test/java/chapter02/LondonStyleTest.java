package chapter02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LondonStyleTest {

    @Test
    @DisplayName("재고 내에서 구매요청 성공 테스트")
    public void purchaseSucceedsWhenEnoughInventory() throws Exception {
        // Arrange, 준비
        IStore store = mock(LondonStore.class);
        when(store.hasEnoughInventory(Product.Shampoo, 5)).thenReturn(true);

        LondonCustomer customer = new LondonCustomer();

        // Act, 실행
        boolean success = customer.purchase(store, Product.Shampoo, 5);

        // Assert, 검증
        Assertions.assertTrue(success);
        verify(store, times(1)).removeInventory(Product.Shampoo, 5);
    }

    @Test
    @DisplayName("재고보다 많은 구매요청 실패 테스트")
    public void purchaseFailsWhenNotEnoughInventory() throws Exception {
        // Arrange, 준비
        IStore store = mock(LondonStore.class);
        when(store.hasEnoughInventory(Product.Shampoo, 15)).thenReturn(false);

        LondonCustomer customer = new LondonCustomer();

        // Act, 실행
        boolean success = customer.purchase(store, Product.Shampoo, 15);

        // Assert, 검증
        Assertions.assertFalse(success);
        verify(store, times(0)).removeInventory(Product.Shampoo, 5);
    }

}
