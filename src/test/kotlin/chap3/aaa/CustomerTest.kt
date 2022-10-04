package chap3.aaa

import chap2.Customer
import chap2.Product
import chap2.Store
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CustomerTest {

    /**
     * 실행 구절이 한 줄인 테스트 코드
     * @JunHyung
     */
    @Test
    fun purchase_succeeds_when_enough_inventory1() {

        val store = Store()
        store.addInventory(product = Product.Shampoo, 10)
        val customer = Customer()

        val success = customer.purChase(store, Product.Shampoo, 5)

        assertTrue(success)
        assertEquals(5, store.getInventory(product = Product.Shampoo))
    }

    /**
     * 실행 구절이 두 줄인 테스트 코드
     * store의 removeInventory 메서드의 프로덕션 코드의 로직이 달라 임시로 지정하여
     * 단일 작업을 수행하는 데 두 개의 메서드 호출이 필요하다는 것을 알리기 위해 테스트 코드 작성
     * @JunHyung
     */
    @Test
    fun purchase_succeeds_when_enough_inventory2() {

        val store = Store()
        store.addInventory(product = Product.Shampoo, 10)
        val customer = Customer()


        val success = customer.purChase(store, Product.Shampoo, 5)
//        store.removeInventory(success, Product.Shampoo, 5)

        assertTrue(success)
        assertEquals(5, store.getInventory(product = Product.Shampoo))
    }
}