package chap2

import chap2.Product.*

class Store {

    fun hasEnoughInventory(product: Product, quantity: Int): Boolean {
        return getInventory(product) >= quantity
    }

    fun removeInventory(product: Product, quantity: Int) {
        if (!hasEnoughInventory(product, quantity)) {
            throw Exception("Not Enough Inventory")
        }

        when (product) {
            Shampoo -> product.stock -= quantity
            Book -> product.stock -= quantity
        }
    }

    fun addInventory(product: Product, quantity: Int) {
        when (product) {
            Shampoo -> product.stock += quantity
            Book -> product.stock += quantity
        }
    }

    fun getInventory(product: Product): Int {
        return when (product) {
            Shampoo -> product.stock
            Book -> product.stock
        }
    }
}