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
    fun shouldPrintHeaderAndBasketContentsWithPrice() {
        val utils = BasketUtils()
        val basket = ShoppingBasket()
        val anItem = GroceryItem("pizza", "7.99")
        basket.add(anItem)

        assertEquals("Item || Quantity || Unit Price\npizza || 1 || 7.99", utils.printBasket(basket))
    }
}