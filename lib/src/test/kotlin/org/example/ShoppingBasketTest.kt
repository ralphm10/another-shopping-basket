package org.example

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ShoppingBasketTest {

    @Test
    fun shouldBeEmptyWhenInitialized() {
        val basket = ShoppingBasket()
        assertTrue(basket.isEmpty())
    }

    @Test
    fun shouldAddAGroceryItem() {
        val basket = ShoppingBasket()
        val anItem = GroceryItem("pizza")

        basket.add(anItem)

        assertFalse(basket.isEmpty())
        assertTrue(basket.items.contains(anItem))
    }

    @Test
    fun shouldRemoveAGroceryItem() {
        val basket = ShoppingBasket()
        val anItem = GroceryItem("pizza")

        basket.add(anItem)
        basket.remove(anItem)

        assertTrue(basket.isEmpty())
        assertFalse(basket.items.contains(anItem))
    }
}