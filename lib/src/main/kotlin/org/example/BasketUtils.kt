package org.example

class BasketUtils {

    fun printBasket(basket: ShoppingBasket): String {
        if (basket.isEmpty()) {
            return "your basket is empty"
        }

        val header = "Item || Quantity || Unit Price || Subtotal"
        val items = basket.items.joinToString("\n")
            { "${it.description} || ${it.quantity} || ${it.unitPrice} || ${it.subTotal()}" }
        val footer = "Basket total is ${basket.total()} for ${basket.itemCount()} items"

        return "$header\n$items\n\n$footer"
    }
}
