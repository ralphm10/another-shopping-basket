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
    fun shouldPrintHeaderAndBasketContents() {
        val utils = BasketUtils()
        val basket = ShoppingBasket()
        val anItem = GroceryItem("pizza")
        basket.add(anItem)

        assertEquals("Item || Quantity\npizza || 1", utils.printBasket(basket))
    }
}