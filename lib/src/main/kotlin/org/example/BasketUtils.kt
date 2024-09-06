package org.example

class BasketUtils {

    fun printBasket(basket: ShoppingBasket): String {
        if (basket.isEmpty()) {
            return "your basket is empty"
        }
        val header = "Item || Quantity"
        val items = basket.items.joinToString("\n") { "${it.description} || ${it.quantity}" }
        return "$header\n$items"
    }
}
