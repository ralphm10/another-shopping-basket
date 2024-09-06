package org.example

import kotlin.test.Test
import kotlin.test.assertTrue

class ShoppingBasketTest {

    @Test
    fun shouldBeEmptyWhenInitialized() {
        val basket = ShoppingBasket()
        assertTrue(basket.isEmpty())
    }
}