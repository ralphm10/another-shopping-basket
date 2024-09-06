package org.example

import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test
import kotlin.test.assertEquals

class BasketUtilsTest {
    private lateinit var utils: BasketUtils
    private lateinit var basket: ShoppingBasket
    private lateinit var anItem: GroceryItem

    @BeforeEach
    fun setup() {
        utils = BasketUtils()
        basket = ShoppingBasket()
        anItem = GroceryItem("pizza", "7.99", 2)
    }

    @Test
    fun shouldPrintMessageIfBasketIsEmpty() {
        assertEquals("your basket is empty", utils.printBasket(basket))
    }

    @Test
    fun shouldPrintHeaderAndBasketContentsWithPriceAndSubtotal() {
        val anotherItem = GroceryItem("red wine", "9.49")

        basket.add(anItem)
        basket.add(anotherItem)

        assertEquals("Item || Quantity || Unit Price || Subtotal\n" +
                "pizza || 2 || 7.99 || 15.98\n" +
                "red wine || 1 || 9.49 || 9.49\n\n" +
                "Basket total is 25.47 for 2 items", utils.printBasket(basket))
    }
}