package chap2

import chap2.Product.*

fun main() {
    val store = Store()
    val customer = Customer()

    store.apply {
        addInventory(product = Shampoo, 20)
        addInventory(product = Shampoo, 10)
        addInventory(product = Book, 30)
    }

    customer.purChase(store, Shampoo, 40)

}

