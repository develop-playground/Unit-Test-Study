package chap3.fixture

import chap2.Customer
import chap2.Product
import chap2.Store
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CustomerTests {

    private lateinit var _store: Store
    private lateinit var _sut: Customer

    @BeforeEach
    fun setUp() {
        _store = Store()
        _store.addInventory(Product.Shampoo, 10)
        _sut = Customer()
    }

    @Test
    fun purchase_succeeds_when_enough_inventory() {

        val success = _sut.purChase(_store, Product.Shampoo, 5)

        assertTrue(success)
        assertEquals(5, _store.getInventory(Product.Shampoo))
    }

    @Test
    fun purchase_fails_when_not_enough_inventory() {

        val success = _sut.purChase(_store, Product.Shampoo, 15)

        assertFalse(success)
        assertEquals(10, _store.getInventory(Product.Shampoo))
    }
}