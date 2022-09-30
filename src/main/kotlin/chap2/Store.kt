package chap2

import chap2.Product.*

class Store {

    private val inventory: MutableMap<Product, Int> = mutableMapOf()

    fun hasEnoughInventory(product: Product, quantity: Int): Boolean {
        return getInventory(product) >= quantity
    }

    fun removeInventory(product: Product, quantity: Int) {
        if (!hasEnoughInventory(product, quantity)) {
            throw Exception("Not Enough Inventory")
        }
        val totalQuantity = inventory[product]!!.minus(quantity)
        inventory[product] = totalQuantity
    }

    fun addInventory(product: Product, quantity: Int) {
        if (inventory.containsKey(product)) {
            val totalQuantity = inventory[product]!!.plus(quantity)
            inventory[product] = totalQuantity
        } else {
            inventory[product] = quantity
        }
    }

    fun getInventory(product: Product): Int {
        return if (inventory.isEmpty()) {
            0
        } else {
            inventory[product]!!
        }
    }
}