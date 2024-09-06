package org.example

class BasketUtils {

    fun printBasket(basket: ShoppingBasket): String {
        if (basket.isEmpty()) {
            return "your basket is empty"
        }
        val header = "Item || Quantity || Unit Price || Subtotal"
        val footer = "Basket total is ${basket.total()} for ${basket.itemCount()} items"
        val items = basket.items.joinToString("\n")
        { "${it.description} || ${it.quantity} || ${it.unitPrice} || ${it.subTotal()}" }

        return "$header\n$items\n\n$footer"
    }
}
