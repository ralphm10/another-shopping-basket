package org.example

import kotlin.test.Test
import kotlin.test.assertEquals

class BasketUtilsTest {

    @Test
    fun shouldPrintMessageIfBasketIsEmpty() {
        val basket = ShoppingBasket()
        val utils = BasketUtils()
        assertEquals("your basket is empty", utils.printBasket(basket))
    }

    @Test
    fun shouldPrintHeaderAndBasketContentsWithPriceAndSubtotal() {
        val utils = BasketUtils()
        val basket = ShoppingBasket()
        val anItem = GroceryItem("pizza", "7.99", 2)
        basket.add(anItem)

        assertEquals("Item || Quantity || Unit Price || Subtotal\n" +
                "pizza || 2 || 7.99 || 15.98", utils.printBasket(basket))
    }
}