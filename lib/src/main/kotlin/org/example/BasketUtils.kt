package org.example

class BasketUtils {

    fun printBasket(basket: ShoppingBasket): String {
        if (basket.isEmpty()) {
            return "your basket is empty"
        }
        val header = "Item || Quantity || Unit Price"
        val items = basket.items.joinToString("\n")
        { "${it.description} || ${it.quantity} || ${it.unitPrice}" }
        return "$header\n$items"
    }
}
