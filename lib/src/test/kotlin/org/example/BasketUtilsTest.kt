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
        val anotherItem = GroceryItem("red wine", "9.49")

        basket.add(anItem)
        basket.add(anotherItem)

        assertEquals("Item || Quantity || Unit Price || Subtotal\n" +
                "pizza || 2 || 7.99 || 15.98\n" +
                "red wine || 1 || 9.49 || 9.49\n\n" +
                "Basket total is 25.47 for 2 items", utils.printBasket(basket))
    }
}