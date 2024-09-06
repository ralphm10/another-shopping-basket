package org.example

class ShoppingBasket(var items: MutableList<GroceryItem> = mutableListOf()) {
    fun isEmpty(): Boolean = items.isEmpty()

    fun add(item: GroceryItem) {
        require(!containsItem(item)) {"${item.description} already in basket"}
        items.add(item)
    }

    fun remove(item: GroceryItem) {
        require(containsItem(item)) {"${item.description} not in basket"}
        items.remove(item)
    }

    private fun containsItem(item: GroceryItem) = items.contains(item)

    fun updateQuantity(item: GroceryItem, quantity: Int) {
        require(containsItem(item)) {"${item.description} not in basket"}
        val foundItem = items.find { it.description == item.description }
        foundItem?.quantity = quantity
    }
}
