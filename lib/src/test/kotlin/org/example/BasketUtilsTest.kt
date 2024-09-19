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
        anItem = GroceryItem("pizza", "7.99", "0.2")
    }

    @Test
    fun shouldPrintMessageIfBasketIsEmpty() {
        assertEquals("your basket is empty", utils.printBasket(basket))
    }

    @Test
    fun shouldPrintHeaderAndBasketContentsWithPriceAndSubtotal() {
        val firstItem = GroceryItem("pizza", "7.99", "0", 2)
        val anotherItem = GroceryItem("red wine", "9.49")

        basket.add(firstItem)
        basket.add(anotherItem)

        assertEquals("Item || Quantity || Unit Price ex Vat || Unit Price inc Vat || Subtotal\n" +
                "pizza || 2 || 7.99 || 7.99 || 15.98\n" +
                "red wine || 1 || 9.49 || 9.49 || 9.49\n\n" +
                "Basket total is 25.47 for 2 items", utils.printBasket(basket))
    }

    @Test
    fun shouldDisplayPriceAndSubtotalIncludingVatForVatItem() {
        val vatItem = GroceryItem("lager", "10.00", "0.2")
        basket.add(vatItem)

        assertEquals("Item || Quantity || Unit Price ex Vat || Unit Price inc Vat || Subtotal\n" +
                "lager || 1 || 10.00 || 12.00 || 12.00\n\n" +
                "Basket total is 12.00 for 1 items", utils.printBasket(basket))
    }

    @Test
    fun shouldDisplayPriceAndSubtotalIncludingVatForNonVatItem() {
        val noVatItem = GroceryItem("lettuce", "0.50", )
        basket.add(noVatItem)

        assertEquals("Item || Quantity || Unit Price ex Vat || Unit Price inc Vat || Subtotal\n" +
                "lettuce || 1 || 0.50 || 0.50 || 0.50\n\n" +
                "Basket total is 0.50 for 1 items", utils.printBasket(basket))
    }
}