package org.example

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ShoppingBasketTest {
    private lateinit var basket: ShoppingBasket

    @BeforeEach
    fun setup() {
        basket = ShoppingBasket()
    }

    @Test
    fun shouldBeEmptyWhenInitialized() {
        assertTrue(basket.isEmpty())
    }

    @Test
    fun shouldAddAGroceryItem() {
        val anItem = GroceryItem("pizza")

        basket.add(anItem)

        assertFalse(basket.isEmpty())
        assertTrue(basket.items.contains(anItem))
    }

    @Test
    fun shouldThrowErrorWhenAddingDuplicateItem() {
        val anItem = GroceryItem("pizza")

        basket.add(anItem)
        val exception = assertThrows<IllegalArgumentException> {
            basket.add(anItem)
        }
        assertEquals("${anItem.description} already in basket", exception.message)
    }

    @Test
    fun shouldRemoveAGroceryItem() {
        val anItem = GroceryItem("pizza")

        basket.add(anItem)
        basket.remove(anItem)

        assertTrue(basket.isEmpty())
        assertFalse(basket.items.contains(anItem))
    }

    @Test
    fun shouldThrowErrorIfItemNotInBasket() {
        val missingItem = GroceryItem("lettuce")

        val exception = assertThrows<IllegalArgumentException> {
            basket.remove(missingItem)
        }

        assertEquals("${missingItem.description} not in basket", exception.message)
    }
}