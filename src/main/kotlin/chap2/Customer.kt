package chap2

class Customer {
    fun purChase(store: Store, product: Product, quantity: Int): Boolean {
        if (!store.hasEnoughInventory(product, quantity)) {
            println("상품의 재고가(${product.stock})이 주문하신 수량(${quantity})보다 적습니다.")
            return false
        }

        store.removeInventory(product, quantity)

        return true
    }
}