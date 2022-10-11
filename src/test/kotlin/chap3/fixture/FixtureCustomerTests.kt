package chap3.fixture

import chap2.Customer
import chap2.Product
import chap2.Store
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class   FixtureCustomerTests {

    /**
     * 비공개 픽토리 메서드를 사용한 테스트 코드
     * @JunHyung
     */
    private fun createStoreWithInventory(product: Product, quantity: Int): Store {
        val store = Store()
        store.addInventory(product, quantity)
        return store
    }

    private fun createCustomer() = Customer()

    @Test
    fun purchase_succeeds_when_enough_inventory() {
        val store: Store = createStoreWithInventory(Product.Shampoo, 10)
        val sut: Customer = createCustomer()

        val success = sut.purChase(store, Product.Shampoo, 5)

        assertTrue(success)
        assertEquals(5, store.getInventory(Product.Shampoo))
    }

    @Test
    fun purchase_fails_when_not_enough_inventory() {
        val store: Store = createStoreWithInventory(Product.Book, 10)
        val sut = createCustomer()

        val success = sut.purChase(store, Product.Book, 15)

        assertFalse(success)
        assertEquals(10, store.getInventory(Product.Book))
    }
}