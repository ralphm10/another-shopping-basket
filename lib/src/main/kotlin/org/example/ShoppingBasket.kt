package org.example

class ShoppingBasket(var items: MutableList<GroceryItem> = mutableListOf()) {
    fun isEmpty(): Boolean = items.isEmpty()

    fun add(item: GroceryItem) {
        require(!items.contains(item)) {"${item.description} already in basket"}
        items.add(item)
    }

    fun remove(item: GroceryItem) {
        require(items.contains(item)) {"${item.description} not in basket"}
        items.remove(item)
    }
}
