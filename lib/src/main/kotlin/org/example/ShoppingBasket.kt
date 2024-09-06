package org.example

import java.math.BigDecimal

class ShoppingBasket(var items: MutableList<GroceryItem> = mutableListOf()) {
    fun isEmpty(): Boolean = items.isEmpty()

    fun add(item: GroceryItem) {
        require(!containsItem(item)) {"${item.description} already in basket"}
        items.add(item)
    }

    fun remove(item: GroceryItem) {
        verifyItemInBasket(item)
        items.remove(item)
    }

    private fun containsItem(item: GroceryItem) = items.contains(item)

    fun updateQuantity(item: GroceryItem, quantity: Int) {
        verifyItemInBasket(item)
        require(quantity > 0) {"Quantity must be greater than 0"}

        val foundItem = items.find { it.description == item.description }
        foundItem?.quantity = quantity
    }

    private fun verifyItemInBasket(item: GroceryItem) {
        require(containsItem(item)) { "${item.description} not in basket" }
    }

    fun itemCount(): Int = items.size

    fun total(): BigDecimal = items.sumOf { it.subTotal() }
}
