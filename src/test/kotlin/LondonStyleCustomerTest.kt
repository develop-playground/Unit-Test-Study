import chap2.Customer
import chap2.Product.Shampoo
import chap2.Store
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LondonStyleCustomerTest {

    private val storeMock: Store = mock()
    private lateinit var customer: Customer

    @BeforeEach
    fun setUp() {
        customer = Customer()
    }

    @Test
    fun purchase_succeeds_when_enough_inventory() {

        whenever(storeMock.hasEnoughInventory(product = Shampoo, 5))
            .thenReturn(true)

        val success = customer.purChase(
            storeMock, Shampoo, 5
        )

        assertTrue(success)
    }

    @Test
    fun purchase_fails_when_not_enough_inventory() {
        whenever(storeMock.hasEnoughInventory(product = Shampoo, 5))
            .thenReturn(false)

        val success = customer.purChase(
            storeMock, Shampoo, 5
        )

        assertFalse(success)
    }
}