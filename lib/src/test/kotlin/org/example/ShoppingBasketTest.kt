package org.example

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ShoppingBasketTest {
    private lateinit var basket: ShoppingBasket
    private lateinit var anItem: GroceryItem

    @BeforeEach
    fun setup() {
        basket = ShoppingBasket()
        anItem = GroceryItem("pizza", "7.99")
    }

    @Test
    fun shouldBeEmptyWhenInitialized() {
        assertTrue(basket.isEmpty())
    }

    @Test
    fun shouldAddAGroceryItem() {
        basket.add(anItem)

        assertFalse(basket.isEmpty())
        assertTrue(basket.items.contains(anItem))
    }

    @Test
    fun shouldAddAGroceryItemWithQuantityGreaterThanOne() {
        val anItemWithQuantityGreaterThanOne = GroceryItem("doritos", "1.99", "0.2", 2)
        basket.add(anItemWithQuantityGreaterThanOne)

        assertEquals(2, basket.items.first().quantity)
    }

    @Test
    fun shouldUpdateItemQuantity() {
        basket.add(anItem)
        basket.updateQuantity(anItem, 5)

        assertEquals(5, basket.items.first().quantity)
    }

    @Test
    fun shouldThrowErrorIfUpdatingItemNotInBasket() {
        val missingItem = GroceryItem("lettuce", "0.59")

        val exception = assertThrows<IllegalArgumentException> {
            basket.updateQuantity(missingItem, 5)
        }

        assertEquals("${missingItem.description} not in basket", exception.message)
    }

    @Test
    fun shouldThrowErrorForIncorrectQuantity() {
        basket.add(anItem)

        val exception = assertThrows<IllegalArgumentException> {
            basket.updateQuantity(anItem, -1)
        }
        assertEquals("Quantity must be greater than 0", exception.message)
    }

    @Test
    fun shouldThrowErrorWhenAddingDuplicateItem() {
        basket.add(anItem)
        val exception = assertThrows<IllegalArgumentException> {
            basket.add(anItem)
        }
        assertEquals("${anItem.description} already in basket", exception.message)
    }

    @Test
    fun shouldRemoveAGroceryItem() {
        basket.add(anItem)
        basket.remove(anItem)

        assertTrue(basket.isEmpty())
        assertFalse(basket.items.contains(anItem))
    }

    @Test
    fun shouldThrowErrorIfRemovingItemNotInBasket() {
        val missingItem = GroceryItem("lettuce", "0.59")

        val exception = assertThrows<IllegalArgumentException> {
            basket.remove(missingItem)
        }

        assertEquals("${missingItem.description} not in basket", exception.message)
    }
}