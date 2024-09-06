package org.example

import kotlin.test.Test
import kotlin.test.assertEquals

class BasketUtilsTest {

    @Test
    fun shouldPrintMessageIfBasketIsEmpty() {
        val utils = BasketUtils()
        assertEquals("your basket is empty", utils.printBasket())
    }
}