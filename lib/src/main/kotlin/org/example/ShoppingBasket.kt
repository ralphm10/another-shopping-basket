package org.example

import java.lang.IllegalArgumentException

class ShoppingBasket(var items: MutableList<GroceryItem> = mutableListOf()) {
    fun isEmpty(): Boolean = items.isEmpty()

    fun add(item: GroceryItem) {
        items.add(item)
    }

    fun remove(item: GroceryItem) {
        if (!items.contains(item)) {
            throw IllegalArgumentException("${item.description} not in basket")
        }
        items.remove(item)
    }
}
