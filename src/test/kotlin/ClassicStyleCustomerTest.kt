import chap2.Customer
import chap2.Product.Shampoo
import chap2.Store
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ClassicStyleCustomerTest {

    @Test
    fun purchase_succeeds_when_enough_inventory() {
        //get
        val store = Store()
        store.addInventory(product = Shampoo, 10)
        val customer = Customer()

        //when
        val success = customer.purChase(store, Shampoo, 5)

        //then
        assertTrue(success)
        assertEquals(5, store.getInventory(product = Shampoo))
    }

    @Test
    fun purchase_fails_when_not_enough_inventory() {
        //get
        val store = Store()
        store.addInventory(product = Shampoo, 10)
        val customer = Customer()

        //when
        val success = customer.purChase(store, Shampoo, 15)

        //then
        assertFalse(success)
        assertEquals(10, store.getInventory(Shampoo))
    }
}